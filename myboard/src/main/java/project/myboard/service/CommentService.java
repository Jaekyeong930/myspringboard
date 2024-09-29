package project.myboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.myboard.model.Comment;
import project.myboard.model.Post;
import project.myboard.repository.CommentRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // get comments in the post
    public List<Comment> getCommentsByPost(Post post) {
        return commentRepository.findByPost(post);
    }


    // save new comment
    public Comment saveComment(Comment comment) {
        comment.setCreatedDate(LocalDateTime.now());
        return commentRepository.save(comment);
    }
}
