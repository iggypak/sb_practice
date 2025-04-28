package com.skillbox.sb_practice.repository;

import com.skillbox.sb_practice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
            SELECT new User(
                u.id,
                u.username,
                u.password,
                u.email,
                NULL,
                NULL,
                u.createdAt,
                u.updatedAt,
                new com.skillbox.sb_practice.entity.CommentCounters(COUNT(c.author.id)),
                new com.skillbox.sb_practice.entity.NewsCounters(COUNT(n.author.id))
            ) 
            FROM User u
            LEFT JOIN News n ON n.author.id = u.id
            LEFT JOIN Comment c ON c.author.id = u.id
            GROUP BY u.id,
                u.username,
                u.password,
                u.email,
                u.createdAt,
                u.updatedAt
            """)
    Page<User> getUsersWithCounters(Pageable pageable);
    @Query("""
            SELECT u FROM User u WHERE u.username = :username""")
    User getUserByUsername(String username);
}
