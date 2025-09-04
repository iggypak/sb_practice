package com.skillbox.sb_practice.controller;

import com.skillbox.sb_practice.dto.comments.CommentResponse;
import com.skillbox.sb_practice.dto.comments.CommonUpsertResponse;
import com.skillbox.sb_practice.dto.news.NewsCreateRequest;
import com.skillbox.sb_practice.dto.news.NewsResponse;
import com.skillbox.sb_practice.dto.news.NewsResponseItem;
import com.skillbox.sb_practice.dto.news.NewsUpdateRequest;
import com.skillbox.sb_practice.service.CommentService;
import com.skillbox.sb_practice.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommonUpsertResponse> create(@RequestBody NewsCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(newsService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonUpsertResponse> update(@PathVariable Long id, @RequestBody NewsUpdateRequest request) {
        return ResponseEntity.accepted().body(newsService.update(id, request));
    }

    @GetMapping
    public ResponseEntity<List<NewsResponseItem>> getByPage(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {

        return ResponseEntity.ok(newsService.getAllNewsByPage(size, page));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        newsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsResponse> getNewsById(@PathVariable Long id) {
        return ResponseEntity.ok(newsService.getNewsById(id));
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<CommentResponse>> getNewsComment(@PathVariable Long id) {
        var response = commentService.commentByNewsId(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
