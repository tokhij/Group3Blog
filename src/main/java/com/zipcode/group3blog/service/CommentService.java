package com.zipcode.group3blog.service;

import com.zipcode.group3blog.dto.CommentDTO;
import com.zipcode.group3blog.exceptions.CommentNotFoundException;
import com.zipcode.group3blog.model.Comment;
import com.zipcode.group3blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CommentService {
    @Autowired
    private AuthService authService;

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public List<CommentDTO> showAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(this::mapFromCommentToDTO).collect(toList());
    }

    private CommentDTO mapFromCommentToDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentId(commentDTO.getCommentId());
        commentDTO.setContent(commentDTO.getContent());
        commentDTO.setContent(comment.getContent());
        commentDTO.setUserId(comment.getUserId());
        return commentDTO;
    }

    @Transactional
    public void createComment(CommentDTO commentDTO) {
        Comment comment = mapFromDTOToComment(commentDTO);
        commentRepository.save(comment);
    }

    private Comment mapFromDTOToComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setContent(commentDTO.getContent());
        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        comment.setCreatedOn(Instant.now());
        comment.setUserId(loggedInUser.getUsername());
        comment.setUpdatedOn(Instant.now());
        return comment;
    }

    @Transactional
    public CommentDTO readSingleComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() ->
                new CommentNotFoundException("For id " + id));
        return mapFromCommentToDTO(comment);
    }
    @Transactional
    public void deleteComment(Long id) {
        CommentDTO commentToDelete = readSingleComment(id);
        Comment comment = mapFromDTOToComment(commentToDelete);
        commentRepository.delete(comment);
    }
}