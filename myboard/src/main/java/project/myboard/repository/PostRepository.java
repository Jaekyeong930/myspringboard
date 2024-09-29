package project.myboard.repository;
import project.myboard.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // JpaRepository를 상속받으면 JPA가 제공하는 데이터베이스 관련 기능을 자동으로 쓸 수 있게 됨
    // 자동으로 CRUD 메소드를 생성
    // save, findById, findAll, deleteById, delete 등
    // 페이징 및 정렬 기능을 제공한다
    // DAO 역할을 수행하는 것
}
