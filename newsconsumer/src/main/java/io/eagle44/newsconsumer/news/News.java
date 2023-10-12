package io.eagle44.newsconsumer.news;


import java.util.UUID;

public class News {
    private UUID uuid;
    private String title;
    private String link;
    private String description;
    private String publicationDate;
    private String source;
    private String imageUrl;

    public News() {
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

    public String getImageUrl() {
        return imageUrl;
    }
}
