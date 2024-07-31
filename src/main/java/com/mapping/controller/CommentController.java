package com.mapping.controller;

import com.mapping.payload.CommentDTO;
import com.mapping.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}")
    public CommentDTO createComment(@PathVariable Long postId, @RequestBody CommentDTO commentDTO) {
        return commentService.createComment(postId, commentDTO);
    }

    @GetMapping("/{id}")
    public CommentDTO getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @GetMapping
    public List<CommentDTO> getAllComments() {
        return commentService.getAllComments();
    }

    @PutMapping("/{id}")
    public CommentDTO updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
        return commentService.updateComment(id, commentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
