package com.ch07.entity;

import com.ch07.dto.User1DTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

//Entity는 setter안씀
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name="user1")  //매핑 테이블 설정
@Entity // 엔티티 객체 정의
public class User1 {  // 클래스이름은  테이블 네임 그대로 사용하는것이 좋다

    @Id
    @Column//pk를 지정해줘야함 반드시 있어야함 , pk 컬럼 설정
    private String uid;

    //column name 속성은 테이블과 필드명과 동일하면 생략가능
    @Column(name="name") //매핑 컬럼 설정(생략가능)
    private String name;

    @Column(name="birth")
    private String birth;

    @Column(name="hp")
    private String hp;

    @Column(name="age")
    private int age;

    //dto 변환메서드
    public User1DTO toDTO() {
        return User1DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .age(age)
                .build();
    }



}
