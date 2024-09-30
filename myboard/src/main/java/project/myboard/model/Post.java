// 게시글 테이블
package project.myboard.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@NoArgsConstructor // 매개변수 없는 생성자 자동 생성
@AllArgsConstructor // 매개변수 있는 생성자 자동 생성
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;
    private String content;
    private String author;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    // post:comment = 1:n
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();
}

// 서비스 클래스란?
// 역할 : 비즈니스 로직을 처리하는 핵심 클래스
// 위치 : 서비스 계층
// 주요 기능 : 데이터 처리, 비즨스 규칙, 트랜잭션 관리 등 핵심 로직 처리
// 의존성 : DB와의 상호작용을 위해 Repository나 DAO 클래스에 의존