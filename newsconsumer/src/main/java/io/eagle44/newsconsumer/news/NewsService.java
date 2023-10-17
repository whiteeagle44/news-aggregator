package io.eagle44.newsconsumer.news;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @KafkaListener(topics="news", groupId = "newsConsumer")
    public void listen(List<NewsDTO> newsDTOs) {
        System.out.println("Received " + newsDTOs.size()  + " news=" + newsDTOs);
        List<News> news = convertToNews(newsDTOs);
        newsRepository.saveAll(news);
    }

    private List<News> convertToNews(List<NewsDTO> newsDTOs) {
        return newsDTOs.stream()
                .map(newsDTO -> new News(newsDTO.title(), newsDTO.url(), newsDTO.description(), newsDTO.publicationDate(),
                        newsDTO.source(), newsDTO.imageURL())).toList();
    }
}
