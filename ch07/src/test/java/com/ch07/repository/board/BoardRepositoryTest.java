package com.ch07.repository.board;

import com.ch07.entity.board.Article;
import com.ch07.entity.board.Comment;
import com.ch07.entity.board.File;
import com.ch07.entity.board.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@SpringBootTest
public class BoardRepositoryTest {
    @Autowired private ArticleRepository articleRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private FileRepository fileRepository;
    @Autowired private CommentRepository commentRepository;


    @Test
    void insertUserTest(){
        User user = User.builder()
                .uid("a103")
                .name("장보고")
                .nick("보고")
                .email("bogo@email.email")
                .build();

        userRepository.save(user);
    };

    @Test
    void insertArticleTest(){
        User user = User.builder()
                .uid("a103")
                .build();

        Article article = Article.builder()
                .title("test3")
                .content("test3")
                .user(user)
                .build();

        articleRepository.save(article);
    };

    @Test
    void insertCommentTest(){
        User user = User.builder()
                .uid("a103")
                .build();

        Article article = Article.builder()
                .ano(3)
                .build();
        Comment comment = Comment.builder()
                            .content("test")
                            .user(user)
                            .article(article)
                            .build();

        commentRepository.save(comment);
        };

    //테스트4 - 파일 등록
    @Test
    void insertFileTest(){
        Article article = Article.builder()
                .ano(3)
                .build();
        File file = File.builder()
                .fno(1)
                .sName("disndkcisndlkc.jpg")
                .oName("테스트1.txt")
                .article(article)
                .build();

        fileRepository.save(file);
    }


    //테스트5 - 글조회
     /*
        @transactional (springframework.annotation)
         - transactional은  service에서 모두 설정해줘야함
         - 양방향으로 처리되는 연관관계에서 다수의 select를 트랜잭션으로 수행
         - 하나의 select는 한번의 세션처리다.( 한번의 connection안에서 수행함)
         - 한번의 세션처리로 트랜잭션 하지 않으면 no session 에러 발생
         - 트랜잭션으로 처리하기 위해서 처리 메서드에 @transactional 선언


         @ToString(exclude="제외할 속성")
          - 엔티티간 양방향 관계설정에서 toString()을 호출할 경우 무한순환 호출이 실행
          - 무한순환 호출이 발생하면 stackoverflow 에러 발생
          - 양방향으로 관계설정된 엔티티에서 어느한쪽을 toString에서 제외함
      */
    @Transactional
    @Test
    void selectArticleTest(){
       List<Article> articles = articleRepository.findAll();

        for(Article article : articles){
            System.out.println(article);
            System.out.println(article.getUser().getName());
            List<Comment> comments = article.getComment();
            List<File> files = article.getFile();
            System.out.println(comments);
            System.out.println(files);

        }



    }








}
