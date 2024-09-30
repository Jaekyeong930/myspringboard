package project.myboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import project.myboard.model.Post;
import project.myboard.service.PostService;

import java.util.List;

@Controller
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // get post list
    @GetMapping("/")
    public String printPostList(Model model) {
        List<Post> postList = postService.getAllPosts();
        model.addAttribute("postList", postList);
        return "post_list";
    }

    // get post detail page
    @GetMapping("/post/{postId}")
    // @PathVariable을 명시하지 않을 경우 500에러가 발생함 (하기 문구 참조)
    // Name for argument of type [java.lang.Long] not specified, and parameter name information not available via reflection. Ensure that the compiler uses the '-parameters' flag.
    public String viewPostDetail(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);
        return "post_detail";
    }
}

// 컨트롤러 클래스란?
// 역할 : 클라이언트의 요청을 받고, 서비스 클래스를 호출하여 결과를 반환
// 위치 : 어플리케이션의 가장 바깥쪽, 프레젠테이션 계층
// 주요 기능 : 클라이언트로부터 HTTP요청을 받고, 결과를 반환
// 의존 : 주로 서비스 클래스에 의존
