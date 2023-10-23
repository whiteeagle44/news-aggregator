package io.eagle44.newsproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NewsProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsProducerApplication.class, args);
	}

}
