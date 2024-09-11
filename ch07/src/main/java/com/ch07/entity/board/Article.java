package com.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude ={"file","comment","user"})
@Builder
@Table(name="board_Article")  //매핑 테이블 설정
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ano;
    private String title;
    private String content;
     /*
      @ManyToOne
      - N:1관계설정 ,
      - Article 엔티티와 User 엔티티간의 관계외 방향성을 고려해서 연관관계 설정
      - Article 엔티티가 조회될때 User엔티티도 같이 조회
      @Joincolumn
        - User entity가 참조되는 컬럼 설정
        - Name 속성은 해당 테이블에서의 컬럼명이 된다.
        - Article 에서는 User가 writer로 들어오게된다.
      */

    //연관관계
    @ManyToOne(fetch = FetchType.LAZY) //one = user
    @JoinColumn(name="writer")
    private User user;

    /*
        @OneToMany
         - 1: N 관계 설정 ,일반적으로 양방향 관계설정, 참조타입이 List<Entity>
         - Article 엔티티와 File 엔티티간의 관계와 방향성을 고려해서 연관관계 설정
         - Article 엔티티가 조회될 때 (List)file엔티티가 같이 조회됨
         - mappedBy 속성은 양방향 관계에서 기준이 되는 속성을 설정 ,FK가 되는 엔티티 속성
     */
    //mappedBy는 기준이 되는 엔티티를 적어줌
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "article")  //many = file
    private List<File> file;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "article") //many = comment
    private List<Comment> comment;

    @CreationTimestamp
    private LocalDateTime rdate;
}
