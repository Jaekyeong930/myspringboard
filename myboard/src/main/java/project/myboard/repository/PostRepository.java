package project.myboard.repository;
import project.myboard.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // JpaRepository가 자동으로 CRUD 메소드를 생성함
}
