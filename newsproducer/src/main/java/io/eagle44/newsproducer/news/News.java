package io.eagle44.newsproducer.news;

import java.time.LocalDateTime;
import java.util.Objects;

public record News(String title, String url, String description, LocalDateTime publicationDate, String source,
                   String imageURL) {
    private static final int MAX_FIELD_LENGTH = 256;

    public News(String title, String url, String description, LocalDateTime publicationDate, String source, String imageURL) {
        NewsValidator.throwIfNewsFieldsIncorrect(title, url, publicationDate, source, imageURL);

        this.title = trimField(title);
        this.url = url;
        this.description = getCorrectDescriptionValue(description);
        this.publicationDate = publicationDate;
        this.source = trimField(source);
        this.imageURL = imageURL;
    }

    private String trimField(String input) {
        if (exceedsMaxFieldLength(input)) {
            return trimToMaxFieldLength(input);
        }
        return input;
    }

    private boolean exceedsMaxFieldLength(String input) {
        return input.length() > MAX_FIELD_LENGTH;
    }

    private String trimToMaxFieldLength(String input) {
        return input.substring(0, Math.min(input.length(), MAX_FIELD_LENGTH));
    }

    private String getCorrectDescriptionValue(String description) {
        if (Objects.isNull(description))
            return "";
        return trimField(description);
    }
}