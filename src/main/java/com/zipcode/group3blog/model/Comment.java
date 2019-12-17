package com.zipcode.group3blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long commentId;
    @Column
    private String content;
    @Column
    private Instant createdOn;
    @Column
    private Instant updatedOn;
    @Column
    @NotBlank
    private String userId;
    @ManyToOne
    private Long postId;



    public Long getCommentId() {
        return commentId;
    }

    public String getContent() {
        return content;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }


    public String getUserId() {
        return userId;
    }
    public Long getPostId() {
        return postId;
    }


    public void setCommentId(Long id) {
        this.commentId = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public void setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setPostId(Long postId) {
        this.postId = postId;
    }

}
