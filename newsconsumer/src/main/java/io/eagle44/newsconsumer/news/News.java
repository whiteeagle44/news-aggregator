package io.eagle44.newsconsumer.news;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class News {
    @Id
    private final UUID uuid = UUID.randomUUID();
    private String title;
    private String url;
    private String description;
    private LocalDateTime publicationDate;
    private String source;
    private String imageUrl;

    public News() {
    }

    public News(String title, String url, String description, LocalDateTime publicationDate, String source, String imageURL) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.publicationDate = publicationDate;
        this.source = source;
        this.imageUrl = imageURL;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public String getSource() {
        return source;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
