package io.eagle44.newsproducer.news;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class NewsController {
    private final static long ONE_HOUR_IN_MILLISECONDS = 3_600_000;
    private final static long NEWS_REFRESH_TIME_IN_MILLISECONDS = 2 * ONE_HOUR_IN_MILLISECONDS;

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @Scheduled(fixedRate = NEWS_REFRESH_TIME_IN_MILLISECONDS)
    @GetMapping("/load-recent-news")
    void getNews() {
        newsService.getNews("");
    }
}
