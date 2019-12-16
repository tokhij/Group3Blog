package com.zipcode.group3blog.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.Instant;
@Entity
public class Comment {
    private Long id;
    private String content;
    private Instant createdOn;
    private Instant updatedOn;
    private String userId;
    @ManyToOne
    private Long postId;



    public Long getId() {
        return id;
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



    public Long getPostId() {
        return postId;
    }
    public String getUserId() {
        return userId;
    }


    public void setId(Long id) {
        this.id = id;
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

    public void setPostId(Long postId) {
        this.postId = postId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
