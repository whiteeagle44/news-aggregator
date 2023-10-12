package io.eagle44.newsproducer.newsdataio;

import com.fasterxml.jackson.annotation.JsonProperty;

record Result(
        String title,
        String link,
        String description,
        String pubDate,
        @JsonProperty("source_id") String sourceId,
        @JsonProperty("image_url") String imageURL
) {
}