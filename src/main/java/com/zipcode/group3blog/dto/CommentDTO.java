package com.zipcode.group3blog.dto;

import com.zipcode.group3blog.model.Post;

public class CommentDTO {
    private Long postId;
    private String username;
    private String content;
    private Long commentId;

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getPostId() {
        return postId;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    public Long getCommentId() {
        return commentId;
    }
}