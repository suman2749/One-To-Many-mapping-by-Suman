package com.mapping.payload;

import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private String text;
    private Long postId;

}
