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

    // read post list
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // get post page by postId
    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    // save new post
    public Post savePost(Post post) {
        return postRepository.save(post);
    }


}
