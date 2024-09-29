package project.myboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.myboard.model.Comment;
import project.myboard.model.Post;
import project.myboard.service.CommentService;
import project.myboard.service.PostService;

@Controller
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;

    @Autowired
    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    // add new comment
    @PostMapping("/post/{postId}/comment")
    public String addComment(@PathVariable Long postId, @RequestParam String content, @RequestParam String author) {
        Post post = postService.getPostById(postId);
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setContent(content);
        comment.setAuthor(author);
        commentService.saveComment(comment);
        return "redirect:/post/" + postId;
    }
    // PathVariable은 URL경로(/example/kim/28) 형식으로 전달됨, RequestParam은 쿼리문 형식으로 전달됨 (/example?name=kim&age=28)


}
