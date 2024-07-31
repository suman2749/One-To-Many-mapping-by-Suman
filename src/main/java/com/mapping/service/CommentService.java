package com.mapping.service;

import com.mapping.payload.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO createComment(Long postId, CommentDTO commentDTO);
    CommentDTO getCommentById(Long id);
    List<CommentDTO> getAllComments();
    CommentDTO updateComment(Long id, CommentDTO commentDTO);
    void deleteComment(Long id);
}
