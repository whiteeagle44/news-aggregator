package io.eagle44.newsproducer.newsdataio;

import io.eagle44.newsproducer.news.NewsResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class NewsDataIOService {
    private final NewsDataIOClient newsDataIOClient;

    public NewsDataIOService(NewsDataIOClient newsDataIOClient) {
        this.newsDataIOClient = newsDataIOClient;
    }

    public List<NewsResponse> getNews(String topic) {
        NewsDataIOResponse newsDataIOResponse = newsDataIOClient.queryNewsApiForNews(topic).getBody();
        return toNewsResponses(newsDataIOResponse);
    }

    private List<NewsResponse> toNewsResponses(NewsDataIOResponse newsDataIOResponse) {
        if (Objects.isNull(newsDataIOResponse)) {
            return List.of();
        }
        return newsDataIOResponse.getResults()
                .stream()
                .map(r -> new NewsResponse(
                        r.getTitle(), r.getLink(), r.getDescription(),
                        r.getPubDate(), r.getSourceId(), r.getImageURL()))
                .toList();
    }
}
