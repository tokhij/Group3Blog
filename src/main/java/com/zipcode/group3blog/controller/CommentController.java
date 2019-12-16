package com.zipcode.group3blog.controller;

import com.zipcode.group3blog.dto.CommentDTO;
import com.zipcode.group3blog.dto.PostDTO;
import com.zipcode.group3blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    // add this into parameter of get/post mapping- /api/{postId}/comments
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity createComment(@RequestBody CommentDTO commentDTO){
        commentService.createComment(commentDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<CommentDTO>> showAllComments() {
        return new ResponseEntity<>(commentService.showAllComments(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}/comments")
    public ResponseEntity<CommentDTO> getSingleComment(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(commentService.readSingleComment(id), HttpStatus.OK);
    }

    @DeleteMapping("/get/{id}/comments")
    public ResponseEntity<Boolean> deletePost(@PathVariable @RequestBody CommentDTO commentDTO) {
        commentService.deleteComment(commentDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

}
