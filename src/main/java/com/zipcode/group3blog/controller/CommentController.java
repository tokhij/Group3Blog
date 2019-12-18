package com.zipcode.group3blog.controller;

import com.zipcode.group3blog.dto.CommentDTO;
import com.zipcode.group3blog.dto.PostDTO;
import com.zipcode.group3blog.repository.CommentRepository;
import com.zipcode.group3blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
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

    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<CommentDTO>> showAllComments(@PathVariable @RequestBody Long postId) {
        return new ResponseEntity<>(commentService.showAllComments(), HttpStatus.OK);
    }

    @GetMapping("comments/{postId}")
    public  ResponseEntity<List<CommentDTO>> showAllCommentstoPost(@PathVariable @RequestBody Long postId) {
        return new ResponseEntity<>(commentService.getCommentFromSpecificPost(postId), HttpStatus.OK);
    }

    @GetMapping("/get/{id}/comments")
    public ResponseEntity<CommentDTO> getSingleComment(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(commentService.readSingleComment(id), HttpStatus.OK);
    }

    @DeleteMapping("/get/{id}/comments")
    public ResponseEntity<Boolean> deletePost(@PathVariable @RequestBody Long commentId) {
        commentRepository.deleteById(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PutMapping
//    public ResponseEntity updateComment(@RequestBody CommentDTO commentDTO){
//        commentService.updateComment(commentDTO);
//        return new ResponseEntity(HttpStatus.OK);
//    }

}
