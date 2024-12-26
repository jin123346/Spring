package co.kr.jin.entity;

import co.kr.jin.dto.ArticleDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String cate1;
    private String cate2;
    private String title;
    private String contents;
    @Builder.Default
    private int comment=0;

    @Builder.Default
    private int file=0;
    @Builder.Default
    private int hit=0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="writer",referencedColumnName = "uid")
    private User user;


    private String regip;

    @CreationTimestamp
    private LocalDateTime rdate;


}
