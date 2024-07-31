package com.mapping.service;

import com.mapping.payload.PostDTO;

import java.util.List;

public interface PostService {
        PostDTO createPost(PostDTO postDTO);
        PostDTO getPostById(Long id);
        List<PostDTO> getAllPosts();
        PostDTO updatePost(Long id, PostDTO postDTO);
        void deletePost(Long id);
    }

