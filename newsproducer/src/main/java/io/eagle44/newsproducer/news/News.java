package io.eagle44.newsproducer.news;

import java.util.UUID;

public class News {
    private final UUID uuid = UUID.randomUUID();
    private final String title;
    private final String link;
    private final String description;
    private final String publicationDate;
    private final String source;
    private final String imageURL;

    public News(String title, String link, String description, String publicationDate, String source, String imageURL) {
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

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getSource() {
        return source;
    }

    public String getImageURL() {
        return imageURL;
    }
}
