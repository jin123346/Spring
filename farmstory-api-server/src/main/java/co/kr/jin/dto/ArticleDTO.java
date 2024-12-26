package co.kr.jin.dto;

import co.kr.jin.entity.Article;
import jakarta.persistence.Transient;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {
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


    private String writer;
    private String regip;
    private String rdate;

    //추가필드
    @Transient
    private String nick;



}
