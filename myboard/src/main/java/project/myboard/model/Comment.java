// 댓글 테이블
package project.myboard.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@NoArgsConstructor // 매개변수 없는 생성자 자동 생성
@AllArgsConstructor // 매개변수 있는 생성자 자동 생성
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   commentId;

    @ManyToOne // 1:n
    @JoinColumn(name = "post_id") // comment 테이블의 post_id가 Post 테이블의 PK를 참조하는 FK가 되도록 설정
    private Post post;

    private String content;
    private String author;
    private LocalDateTime createdDate;
}
