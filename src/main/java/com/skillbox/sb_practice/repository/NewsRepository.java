package com.skillbox.sb_practice.repository;

import com.skillbox.sb_practice.entity.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    @Query("""
    SELECT new News(n.id, n.title, n.text, n.author, n.category, NULL, n.createdAt, n.updatedAt, 
                    new com.skillbox.sb_practice.entity.CommentCounters(COUNT(c.id)))
    FROM News n
    LEFT JOIN Comment c ON c.news.id = n.id
    GROUP BY n.id, n.title, n.text, n.author, n.category, n.createdAt, n.updatedAt
""")
    List<News> findAllNewsWithCounters(Pageable pageable);
}
