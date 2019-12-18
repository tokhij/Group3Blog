package com.zipcode.group3blog.repository;

import com.zipcode.group3blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment getCommentFromSpecificPost(Long postId);

}
