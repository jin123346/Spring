package com.ch07.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name="Parent")  //매핑 테이블 설정
@Entity
public class Parent {
    @Id
    private String pid;
    private String name;
    private String birth;
    private String addr;

}
