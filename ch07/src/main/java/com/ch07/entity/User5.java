package com.ch07.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Repository;

@Getter
@Table(name="user5")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class User5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 필드(컬럼) 값이 자동 1증가(auto_increment)
    private int seq;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private int age;

    @Column
    private String addr;
}
