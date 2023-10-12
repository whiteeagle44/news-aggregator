package io.eagle44.newsproducer.news;

import io.eagle44.newsproducer.newsdataio.NewsDataIOService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class NewsService {
    private final NewsDataIOService newsDataIOService;

    public NewsService(NewsDataIOService newsDataIOService) {
        this.newsDataIOService = newsDataIOService;
    }

    public List<NewsResponse> getNews(String topic) {
        return newsDataIOService.getNews(topic);
    }
}
