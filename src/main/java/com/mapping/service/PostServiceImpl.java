package com.mapping.service;

import com.mapping.entity.Comment;
import com.mapping.entity.Post;
import com.mapping.payload.CommentDTO;
import com.mapping.payload.PostDTO;
import com.mapping.repository.CommentRepository;
import com.mapping.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());

        post = postRepository.save(post);

        return mapToDTO(post);
    }

    @Override
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        return mapToDTO(post);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public PostDTO updatePost(Long id, PostDTO postDTO) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());

        post = postRepository.save(post);

        return mapToDTO(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    private PostDTO mapToDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setComments(post.getComments().stream().map(this::mapToDTO).collect(Collectors.toList()));
        return postDTO;
    }

    private CommentDTO mapToDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setText(comment.getText());
        commentDTO.setPostId(comment.getPost().getId());
        return commentDTO;
    }


}
