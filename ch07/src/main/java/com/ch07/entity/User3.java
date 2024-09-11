package com.ch07.entity;

import com.ch07.dto.User3DTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="user3")
@Entity
public class User3 {

    @Id
    private String uid;

    @Column
    private String name;
    @Column
    private String birth;
    @Column
    private String hp;
    @Column
    private String addr;

    public User3DTO toDTO(){
       return User3DTO.builder()
               .uid(uid)
               .name(name)
               .birth(birth)
               .hp(hp)
               .addr(addr)
               .build();
    }
}
