package project.myboard.service;

import org.springframework.stereotype.Service;
import project.myboard.model.Post;
import project.myboard.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // read post list 게시글 리스트를 불러온다.
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // get post page by postId 게시글 페이지를 post_id를 키값으로 하여 검색, 불러온다.
    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    // save new post 새로운 게시글을 보존한다.
    public Post savePost(Post post) {
        return postRepository.save(post);
    }


}
