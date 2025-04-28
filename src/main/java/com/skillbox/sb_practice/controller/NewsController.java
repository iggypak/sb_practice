package com.skillbox.sb_practice.controller;

import com.skillbox.sb_practice.dto.*;
import com.skillbox.sb_practice.service.NewsService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

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

}
