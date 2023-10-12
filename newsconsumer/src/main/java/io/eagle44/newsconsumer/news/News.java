package io.eagle44.newsconsumer.news;


import java.util.UUID;

public record News(UUID uuid, String title, String link, String description, String source, String imageUrl) {
}