package com.zipcode.group3blog.controller;

import com.zipcode.group3blog.dto.CommentDto;
import com.zipcode.group3blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CommentController {
    // add this into parameter of get/ post mapping- /{postId}/comments
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity createComment(@RequestBody CommentDto commentDto){
        commentService.createComment(commentDto);
    }


}
