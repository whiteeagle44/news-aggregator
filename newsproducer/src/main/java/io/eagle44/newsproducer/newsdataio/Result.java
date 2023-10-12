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

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getSourceId() {
        return sourceId;
    }

    public String getImageURL() {
        return imageURL;
    }
}
