package io.eagle44.newsproducer.news;

import java.util.UUID;

public class NewsResponse {
    private final UUID uuid = UUID.randomUUID();
    private String title;
    private String link;
    private String description;
    private String publicationDate;
    private String source;
    private String imageURL;

    public NewsResponse() {
    }

    public NewsResponse(String title, String link, String description, String publicationDate, String source, String imageURL) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.publicationDate = publicationDate;
        this.source = source;
        this.imageURL = imageURL;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
