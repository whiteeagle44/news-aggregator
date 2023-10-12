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
    private final KafkaTemplate<Integer, List<News>> kafkaTemplate;

    public NewsService(NewsDataIOService newsDataIOService, KafkaTemplate<Integer,  List<News>> kafkaTemplate) {
        this.newsDataIOService = newsDataIOService;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void getNews(String topic) {
        List<News> news = newsDataIOService.getNews(topic);
        publishKafkaNews(news);
    }

    public void publishKafkaNews(List<News> news) {
        CompletableFuture<SendResult<Integer,  List<News>>> future = kafkaTemplate.send("news", news);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent "  + news.size() + " news=" + news + " with offset=[" + result.getRecordMetadata().offset() + "");
            } else {
                System.out.println("Unable to send news=" + news.get(0).title()  + " due to : " + ex.getMessage());
            }
        });
    }
}
