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
    private final KafkaTemplate<String, String> kafkaTemplate;

    public NewsService(NewsDataIOService newsDataIOService, KafkaTemplate<String, String> kafkaTemplate) {
        this.newsDataIOService = newsDataIOService;
        this.kafkaTemplate = kafkaTemplate;
    }

    public List<NewsResponse> getNews(String topic) {
        return newsDataIOService.getNews(topic);
    }

    public void publishKafkaMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("topic1", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
