package com.ch08.dto;

import com.ch08.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String username;  // security는 uid를 username이라고 함
    private String password;
    private String name;
    private String birth;
    private String role;
    private String rdate;

    public User toEntity(){
       return User.builder()
                .username(username)
                .password(password)
                .name(name)
                .birth(birth)
                .role(role)
                .build();
    }
}
