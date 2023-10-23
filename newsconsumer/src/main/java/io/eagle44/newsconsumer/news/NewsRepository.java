package io.eagle44.newsconsumer.news;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface NewsRepository extends JpaRepository<News, UUID> {
}