package com.ch08.entity;

import com.ch08.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {

    @Id
    private String username;  // security는 uid를 username이라고 함
    private String password;
    private String name;
    private String birth;
    private String role;

    @CreationTimestamp
    private LocalDateTime rdate;

    public UserDTO toDTO(){
        return UserDTO.builder()
                .username(username)
                .password(password)
                .name(name)
                .birth(birth)
                .role(role)
                .build();
    }

    
}
