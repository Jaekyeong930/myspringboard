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
