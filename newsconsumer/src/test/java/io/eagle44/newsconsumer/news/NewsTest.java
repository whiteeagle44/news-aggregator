package io.eagle44.newsconsumer.news;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class NewsTest {
    @Test
    void newsWithSameFieldsAreAssignedSameUUIDs() {
        News news1 = getMockedNews();
        News news2 = getMockedNews();
        Assertions.assertEquals(news1.getUuid(), news2.getUuid());
    }

    @Test
    void newsWithDifferentFieldsAreAssignedDifferentUUIDs() {
        News news1 = getMockedNews();
        News news2 = getMockedNews2();
        Assertions.assertNotEquals(news1.getUuid(), news2.getUuid());
    }

    private News getMockedNews() {
        return new News("foo", "foo", "", LocalDateTime.of(2020, 1, 1,22,22,22), "foo", "foo");
    }

    private News getMockedNews2() {
        return new News("foo2", "foo", "", LocalDateTime.of(2020, 1, 1,22,22,22), "foo", "foo");
    }
}