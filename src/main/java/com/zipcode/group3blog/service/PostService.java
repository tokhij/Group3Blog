package com.zipcode.group3blog.service;

import com.zipcode.group3blog.dto.PostDTO;
import com.zipcode.group3blog.exceptions.PostNotFoundException;
import com.zipcode.group3blog.model.Post;
import com.zipcode.group3blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PostService {

    @Autowired
    private AuthService authService;
    @Autowired
    private PostRepository postRepository;

    @Transactional
    public List<PostDTO> showAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(this::mapFromPostToDTO)
                .collect(toList());
    }

    @Transactional
    public void createPost(PostDTO postDto) {
        Post post = mapFromDTOToPost(postDto);
        postRepository.save(post);
    }

    @Transactional
    public PostDTO readSinglePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new PostNotFoundException("For id " + id));
        return mapFromPostToDTO(post);
    }

    private PostDTO mapFromPostToDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(post.getPostId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setUsername(post.getUsername());
        return postDTO;
    }

    private Post mapFromDTOToPost(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("Users Not Found"));
        post.setCreatedOn(Instant.now());
        post.setUsername(loggedInUser.getUsername());
        post.setUpdatedOn(Instant.now());
        return post;
    }

    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public void updatePost(PostDTO newPostDTO) {
        Post post = postRepository.getOne(newPostDTO.getPostId());
        post.setContent(newPostDTO.getContent());
        post.setTitle(newPostDTO.getTitle());
        post.setUpdatedOn(Instant.now());
        postRepository.save(post);
    }

}
