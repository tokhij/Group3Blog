package com.zipcode.group3blog.controller;

import com.zipcode.group3blog.dto.CommentDTO;
import com.zipcode.group3blog.model.Comment;
import com.zipcode.group3blog.repository.CommentRepository;
import com.zipcode.group3blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentRepository commentRepository;

    @PostMapping
    public ResponseEntity createComment(@RequestBody CommentDTO commentDTO){
        commentService.createComment(commentDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Valid
    @GetMapping
    public ResponseEntity<Page<Comment>> showAllComments(Pageable pageable) {
        Page<Comment> allComments = commentRepository.findAllBy(pageable);
        return new ResponseEntity<>(allComments, HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentDTO>> showAllCommentsByPost(@PathVariable @RequestBody Long postId) {
        return new ResponseEntity<>(commentService.showAllCommentsByPost(postId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getSingleComment(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(commentService.readSingleComment(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<Boolean> deletePost(@PathVariable @RequestBody Long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateComment(@RequestBody CommentDTO commentDTO){
        commentService.updateComment(commentDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

}
