package io.eagle44.newsproducer.news;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/iga")
    List<NewsResponse> getNews() {
        return newsService.getNews("Iga%20Swiatek");
    }

    @GetMapping("kafka")
    void publishKafkaMessage() {
        newsService.publishKafkaMessage("hello");
    }
}
