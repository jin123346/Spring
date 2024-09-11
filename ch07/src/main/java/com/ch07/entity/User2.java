package com.ch07.entity;

import com.ch07.dto.User2DTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name="user2")
@Entity
public class User2 {
    @Id
    private String uid;

    @Column
    private String name;
    @Column
    private String birth;
    @Column
    private String addr;

    public User2DTO toDTO(){
        return User2DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();
    }
}
