package io.eagle44.newsconsumer.news;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
class NewsService {
    @KafkaListener(topics="news", groupId = "newsConsumer")
    public void listen(News news) {
        System.out.println("Received message in newsConsumer : " + news.getTitle());
    }
}
