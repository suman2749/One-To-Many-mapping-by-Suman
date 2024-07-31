package com.mapping.payload;

import com.mapping.entity.Comment;
import lombok.Data;

import java.util.List;
@Data
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private List<CommentDTO> comments;

    // Getters and Setters
}