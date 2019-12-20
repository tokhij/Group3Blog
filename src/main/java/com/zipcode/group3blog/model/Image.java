package com.zipcode.group3blog.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Data
@Entity
@Table
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Users poster;
    @Column
    private Byte imageContent;
    @Column
    private Instant createdOn;
    @Column
    @NotBlank
    private String username;
    @ManyToOne
    private Post post;

}
