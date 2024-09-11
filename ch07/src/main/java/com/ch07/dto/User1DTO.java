package com.ch07.dto;

import com.ch07.entity.User1;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Setter
public class User1DTO {
    private String uid;
    private String name;
    private String birth;
    private String hp;
    private int age;

    //entity 변환 메서드가 필요함
    public User1 toEntity() {
        return User1.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .age(age)
                .build();
    }

}
