package com.mapping.controller;

import com.mapping.payload.PostDTO;
import com.mapping.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/create/post")
public class PostController {

    @Autowired
    private PostService postService;
///--------------------------------------------------------------
    @PostMapping
    public PostDTO createPost(@RequestBody PostDTO postDTO) {
        return postService.createPost(postDTO);
    }
//...........................................................................
    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }
//........................................................................
    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }
//.......................................................................
    @PutMapping("/{id}")
    public PostDTO updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
        return postService.updatePost(id, postDTO);
    }
//.........................................................
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
