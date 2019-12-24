package com.zipcode.group3blog.repository;

import com.zipcode.group3blog.model.Comment;
import com.zipcode.group3blog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost_PostId(Long postId);
    Page<Comment> findAllBy(Pageable pageable);


}
