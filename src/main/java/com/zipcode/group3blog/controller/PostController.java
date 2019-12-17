package com.zipcode.group3blog.controller;

import com.zipcode.group3blog.dto.PostDTO;
import com.zipcode.group3blog.model.Post;
import com.zipcode.group3blog.repository.PostRepository;
import com.zipcode.group3blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts/")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    PostRepository postRepository;
    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping
    public ResponseEntity createPost(@RequestBody PostDTO postDto) {
        postService.createPost(postDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Valid
    @GetMapping("/all")
    public ResponseEntity<Page<Post>> showAllPosts(Pageable pageable) {
        Page<Post> allPosts = postRepository.findAllBy(pageable);
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDTO> getSinglePost(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(postService.readSinglePost(id), HttpStatus.OK);
    }

    @DeleteMapping("/get/{id}")
    public ResponseEntity<Boolean> deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
        }
    }

