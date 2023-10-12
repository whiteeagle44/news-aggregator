package io.eagle44.newsproducer.newsdataio;

import com.fasterxml.jackson.annotation.JsonProperty;

class Result {
    private String title;
    private String link;
    private String description;
    private String pubDate;
    @JsonProperty("source_id")
    private String sourceId;
    @JsonProperty("image_url")
    private String imageURL;

    public Result() {
    }

    public Result(String title, String link, String description, String pubDate, String sourceId, String imageURL) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;
        this.sourceId = sourceId;
        this.imageURL = imageURL;
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

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
