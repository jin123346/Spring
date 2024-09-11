package com.ch07.entity.board;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name="board_user")  //매핑 테이블 설정
@Entity
public class User {
    @Id
    private String uid;
    private String name;
    private String nick;
    private String email;


    @CreationTimestamp
    private LocalDateTime regDate;


}
