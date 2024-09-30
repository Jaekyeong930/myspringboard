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

    @Autowired // Autowired 어노테이션을 사용함으로써
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // get comments in the post 선택한 게시글의 댓글을 불러온다.
    public List<Comment> getCommentsByPost(Post post) {
        return commentRepository.findByPost(post);
    }


    // save new comment 새로운 댓글 보존
    public Comment saveComment(Comment comment) {
        comment.setCreatedDate(LocalDateTime.now());
        return commentRepository.save(comment);
    }
}
