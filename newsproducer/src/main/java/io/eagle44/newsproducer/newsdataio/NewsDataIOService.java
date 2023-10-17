package io.eagle44.newsproducer.newsdataio;

import io.eagle44.newsproducer.news.News;
import io.eagle44.newsproducer.news.NewsValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class NewsDataIOService {
    private final NewsDataIOClient newsDataIOClient;

    public NewsDataIOService(NewsDataIOClient newsDataIOClient) {
        this.newsDataIOClient = newsDataIOClient;
    }

    public List<News> getNews(String topic) {
        NewsDataIOResponse newsDataIOResponse = newsDataIOClient.queryNewsApiForNews(topic).getBody();
        return convertToNews(newsDataIOResponse);
    }

    private List<News> convertToNews(NewsDataIOResponse newsDataIOResponse) {
        if (Objects.isNull(newsDataIOResponse)) {
            return Collections.emptyList();
        }
        return newsDataIOResponse.results()
                .stream()
                .filter(this::isCorrectNews)
                .map(this::convertToNews)
                .toList();
    }

    private boolean isCorrectNews(Result result) {
        try {
            NewsValidator.throwIfNewsFieldsIncorrect(result.title(), result.link(), convertToLocalDateTime(result.pubDate()), result.sourceId(), result.imageURL());
        } catch (IllegalArgumentException | NullPointerException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }

    private News convertToNews(Result result) {
        return new News(
                result.title(), result.link(), result.description(),
                convertToLocalDateTime(result.pubDate()), result.sourceId(), result.imageURL());
    }

    private LocalDateTime convertToLocalDateTime(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateTime, formatter);
    }
}
