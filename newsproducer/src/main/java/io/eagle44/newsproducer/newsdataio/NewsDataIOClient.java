package io.eagle44.newsproducer.newsdataio;

import io.eagle44.newsproducer.exceptions.ServiceUnavailableException;
import io.eagle44.newsproducer.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.util.retry.Retry;

import java.net.URI;
import java.time.Duration;
import java.util.function.Predicate;

@Component
class NewsDataIOClient {
    private final WebClient.Builder builder;

    @Value("${newsdataio-base-url}")
    private String baseUrl;

    @Value("${newsdataio-token}")
    private String token;

    public NewsDataIOClient(WebClient.Builder builder) {
        this.builder = builder;
    }

    public ResponseEntity<NewsDataIOResponse> queryNewsApiForNews(String topic) throws ResponseStatusException {
        Predicate<Throwable> is5xx =  (throwable) -> throwable instanceof WebClientResponseException && ((WebClientResponseException)throwable).getStatusCode().is5xxServerError();
        Retry retry5xx = Retry.backoff(2, Duration.ofSeconds(2))
                .filter(is5xx)
                .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) -> {
                    throw new ServiceUnavailableException("External service failed to process after max retries");
                });

        URI uri;
        if (!topic.isEmpty()) {
            uri = buildQueryUri(topic);
        } else {
            uri = buildQueryUri();
        }

        return builder
                .defaultHeader("X-ACCESS-KEY",  token)
                .clientConnector(new ReactorClientHttpConnector(HttpClient.newConnection().compress(true)))
                .build()
                .get()
                .uri(uri)
                .retrieve()
                .onStatus(HttpStatus.UNAUTHORIZED::equals, response -> Mono.error(new UnauthorizedException("Bad credentials")))
                .toEntity(NewsDataIOResponse.class)
                .retryWhen(retry5xx)
                .block();
    }

    private URI buildQueryUri() {
        return URI.create(baseUrl);
    }

    private URI buildQueryUri(String topic) {
        String repoQueryUri = baseUrl + "&q=" + topic;
        return URI.create(repoQueryUri);
    }
}
