package io.eagle44.newsproducer.news;

import io.eagle44.newsproducer.newsdataio.NewsDataIOService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
class NewsService {
    private final NewsDataIOService newsDataIOService;
    private final KafkaTemplate<Integer, News> kafkaTemplate;

    public NewsService(NewsDataIOService newsDataIOService, KafkaTemplate<Integer, News> kafkaTemplate) {
        this.newsDataIOService = newsDataIOService;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void getNews(String topic) {
        List<News> news = newsDataIOService.getNews(topic);
        publishKafkaNews(news.get(0));
    }

    public void publishKafkaNews(News news) {
        CompletableFuture<SendResult<Integer, News>> future = kafkaTemplate.send("news", news);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent news=[" + news.getTitle() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send news=[" + news.getTitle()  + "] due to : " + ex.getMessage());
            }
        });
    }
}
