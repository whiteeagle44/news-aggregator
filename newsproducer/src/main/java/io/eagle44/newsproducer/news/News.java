package io.eagle44.newsproducer.news;

public record News(String title, String link, String description, String publicationDate, String source,
                   String imageURL) {
}