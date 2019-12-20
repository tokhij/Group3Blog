package com.zipcode.group3blog.exceptions;

import com.zipcode.group3blog.model.Comment;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(String message) {
        super(message);
    }
}
