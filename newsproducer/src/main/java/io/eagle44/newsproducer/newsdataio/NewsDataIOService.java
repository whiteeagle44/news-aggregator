package io.eagle44.newsproducer.newsdataio;

import io.eagle44.newsproducer.news.News;
import org.springframework.stereotype.Service;

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
        return toNewsResponses(newsDataIOResponse);
    }

    private List<News> toNewsResponses(NewsDataIOResponse newsDataIOResponse) {
        if (Objects.isNull(newsDataIOResponse)) {
            return List.of();
        }
        return newsDataIOResponse.getResults()
                .stream()
                .map(r -> new News(
                        r.getTitle(), r.getLink(), r.getDescription(),
                        r.getPubDate(), r.getSourceId(), r.getImageURL()))
                .toList();
    }
}
