package io.eagle44.newsconsumer.news;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
class News implements Serializable {
    @Id
    private UUID uuid;
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
        this.uuid = generateUUID();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(uuid, news.uuid) && Objects.equals(title, news.title) && Objects.equals(url, news.url) && Objects.equals(description, news.description) && Objects.equals(publicationDate, news.publicationDate) && Objects.equals(source, news.source) && Objects.equals(imageUrl, news.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, title, url, description, publicationDate, source, imageUrl);
    }

    private UUID generateUUID() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.flush();
            byte[] bytes = byteArrayOutputStream.toByteArray();
            return UUID.nameUUIDFromBytes(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error occurred while generating UUID: " + e.getMessage(), e);
        }
    }

}
