package com.zipcode.group3blog.dto;

public class CommentDto {
    private Long postId;
    private String userId;
    private String content;
    private Long commentId;

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public Long getCommentId() {
        return commentId;
    }
}