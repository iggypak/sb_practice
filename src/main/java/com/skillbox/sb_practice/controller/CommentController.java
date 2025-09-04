package com.skillbox.sb_practice.controller;

import com.skillbox.sb_practice.dto.comments.CommentResponse;
import com.skillbox.sb_practice.dto.comments.CommentUpsertRequest;
import com.skillbox.sb_practice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity addComment(@RequestBody CommentUpsertRequest request) {
        commentService.addComment(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CommentResponse>> getCommentsByNewsId(Long newsId) {
        var response = commentService.commentByNewsId(newsId);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
