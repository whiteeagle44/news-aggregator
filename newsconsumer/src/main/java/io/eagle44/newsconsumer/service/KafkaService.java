package io.eagle44.newsconsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @KafkaListener(topics="topic1", groupId = "groupId1")
    public void listen(String message) {
        System.out.println("Received message in groupId1 : " + message);
    }
}
