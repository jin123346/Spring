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
@Table(name="child")  //매핑 테이블 설정
@Entity
public class Child {
    @Id
    private String cid;

    private String name;
    private String hp;
    private String parent;
}
