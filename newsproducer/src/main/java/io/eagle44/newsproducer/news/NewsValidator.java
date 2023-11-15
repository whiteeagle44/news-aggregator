package io.eagle44.newsproducer.news;

import java.time.LocalDateTime;
import java.util.Objects;

public class NewsValidator {
    private static final int MAX_URL_LENGTH = 1020;
    private static final String EMPTY_FIELD_ERROR = "Field cannot be empty";
    private static final String NULL_FIELD_ERROR = "Field cannot be null";
    private static final String URL_LENGTH_ERROR = "URL cannot exceed " + MAX_URL_LENGTH;

    private NewsValidator() {}

    public static void throwIfNewsFieldsIncorrect(String title, String url, LocalDateTime publicationDate, String source, String imageURL) {
        throwIfAnyDoesNotContainValue(title, url, source, imageURL);
        throwIfAnyURLTooLong(url, imageURL);
        throwIfNull(publicationDate);
    }

    private static void throwIfAnyDoesNotContainValue(String... inputs) {
        for (String input : inputs) {
            throwIfNull(input);
            throwIfEmpty(input);
        }
    }


    private static void throwIfNull(Object input) {
        Objects.requireNonNull(input, NULL_FIELD_ERROR);
    }

    private static void throwIfEmpty(String input) {
        if (input.length() == 0)
            throw new IllegalArgumentException(EMPTY_FIELD_ERROR);
    }

    private static void throwIfAnyURLTooLong(String... urls) {
        for (String url : urls)
            throwIfURLTooLong(url);
    }

    private static void throwIfURLTooLong(String url) {
        if (url.length() > MAX_URL_LENGTH)
            throw new IllegalArgumentException(URL_LENGTH_ERROR);
    }
}
