package io.eagle44.newsconsumer.news;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class NewsService {
    @KafkaListener(topics="news", groupId = "newsConsumer")
    public void listen(List<News> news) {
        System.out.println("Received " + news.size()  + " news=" + news);
    }
}
