package com.zipcode.group3blog.service;

import com.zipcode.group3blog.model.Comment;
import com.zipcode.group3blog.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }
    @Transactional
    public Iterable<Comment> index() {
        return commentRepository.findAll();
    }
    @Transactional
    public Comment showComment(Long commentId) {
        return commentRepository.findById(commentId).get();
    }
    @Transactional
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    public Comment updateComment(Long commentId, Comment newCommentData) {
        Comment originalComment = commentRepository.findById(commentId).get();
        originalComment.setContent(newCommentData.getContent());
        return commentRepository.save(originalComment);
    }
    @Transactional
    public Boolean deleteComment(Long id) {
        commentRepository.deleteById(id);
        return true;
    }
}
