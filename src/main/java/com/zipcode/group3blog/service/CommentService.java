package com.zipcode.group3blog.service;

import com.zipcode.group3blog.dto.CommentDTO;
import com.zipcode.group3blog.dto.PostDTO;
import com.zipcode.group3blog.exceptions.CommentNotFoundException;
import com.zipcode.group3blog.model.Comment;
import com.zipcode.group3blog.model.Post;
import com.zipcode.group3blog.repository.CommentRepository;
import com.zipcode.group3blog.repository.PostRepository;
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

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public List<CommentDTO> showAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(this::mapFromCommentToDTO).collect(toList());
    }

    @Transactional
    public List<CommentDTO> showAllCommentsByPost(Long postId) {
        List<Comment> comments = commentRepository.findByPost_PostId(postId);
        return comments.stream().map(this::mapFromCommentToDTO).collect(toList());
    }

    private CommentDTO mapFromCommentToDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentId(comment.getCommentId());
        commentDTO.setContent(comment.getContent());
        commentDTO.setContent(comment.getContent());
        commentDTO.setUsername(comment.getUsername());
        commentDTO.setPostId(comment.getPost().getPostId());
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
        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        comment.setCreatedOn(Instant.now());
        comment.setUsername(loggedInUser.getUsername());
        comment.setUpdatedOn(Instant.now());
        comment.setPost(postRepository.getOne(commentDTO.getPostId()));
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

    @Transactional
    public void updateComment(CommentDTO newCommentDTO) {
        Comment comment = commentRepository.getOne(newCommentDTO.getCommentId());
        comment.setContent(newCommentDTO.getContent());
        comment.setUpdatedOn(Instant.now());
        commentRepository.save(comment);
    }
}