package com.zipcode.group3blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Column
    private String content;
    @Column
    private Instant createdOn;
    @Column
    private Instant updatedOn;
    @Column
    @NotBlank
    private String username;
    @ManyToOne
    private Post post;

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

    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void getPostId () {
        this.post.getPostId();
    }
}
