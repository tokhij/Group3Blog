package com.zipcode.group3blog.repository;

import com.zipcode.group3blog.model.Comment;
import com.zipcode.group3blog.model.Image;
import com.zipcode.group3blog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Comment, Long> {
    Page<Post> findAllBy(Image image);

}
