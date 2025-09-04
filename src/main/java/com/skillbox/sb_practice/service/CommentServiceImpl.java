package com.skillbox.sb_practice.service;

import com.skillbox.sb_practice.dto.comments.CommentResponse;
import com.skillbox.sb_practice.dto.comments.CommentUpsertRequest;
import com.skillbox.sb_practice.mapper.CommentMapper;
import com.skillbox.sb_practice.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public List<CommentResponse> commentByNewsId(Long id) {
        return commentMapper.map(commentRepository.getCommentsByNewsId(id));
    }

    @Override
    public CommentResponse addComment(CommentUpsertRequest request) {
        var saved = commentRepository.save(commentMapper.map(request));
        return commentMapper.map(saved);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void updateComment(CommentUpsertRequest request) {
        throw new NotImplementedException();
    }

    @Override
    public CommentResponse getCommentById(Long id) {
        throw new NotImplementedException();
    }
}
