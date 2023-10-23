package io.eagle44.newsconsumer.news;

import java.time.LocalDateTime;

record NewsDTO(String title, String url, String description, LocalDateTime publicationDate, String source, String imageURL) {
}