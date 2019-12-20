package com.zipcode.group3blog.dto;

public class ImageDTO {
    Long id;
    String username;
    Byte imageContent;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Byte getImageContent() {
        return imageContent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setImageContent(Byte imageContent) {
        this.imageContent = imageContent;
    }

}
