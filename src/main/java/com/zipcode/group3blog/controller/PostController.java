package com.zipcode.group3blog.controller;

import com.zipcode.group3blog.dto.PostDTO;
import com.zipcode.group3blog.exceptions.PostNotFoundException;
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

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @PostMapping
    public ResponseEntity createPost(@RequestBody PostDTO postDTO) {
        postService.createPost(postDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Valid
    @GetMapping
    public ResponseEntity<Page<Post>> showAllPosts(Pageable pageable) {
        Page<Post> allPosts = postRepository.findAllBy(pageable);
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getSinglePost(@PathVariable @RequestBody Long postId) {
        return new ResponseEntity<>(postService.readSinglePost(postId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<Boolean> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.OK);
        }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody PostDTO postDTO) throws PostNotFoundException {
        postService.updatePost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

