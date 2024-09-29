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

    // Read post lisst
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Search post page by postId
    public Post getPostById(long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    // Store post
    public Post savePost(Post post) {
        return postRepository.save(post);
    }


}
