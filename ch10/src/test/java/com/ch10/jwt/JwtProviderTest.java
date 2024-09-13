package com.ch10.jwt;

import com.ch10.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    void createToken() {
        User user = User.builder()
                .username("a223")
                .name("test")
                .birth("1999-09-09")
                .role("ADMIN")
                .build();

        String jwt = jwtProvider.createToken(user, 0);
        System.out.println(jwt);
    }

    @Test
    void getClaims() {
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJoYWpoaTc4OTlAZ21haWwuY29tIiwiaWF0IjoxNzI2MTIyOTA5LCJleHAiOjE3MjYyMDkzMDksInVzZXJuYW1lIjoiYTMzMyIsInJvbGUiOiJBRE1JTiJ9.e9oTEFLJ1Bx4MrjIeaCRc5tlTWOsyyPwELnQnEzU1qY";

       Claims claims= jwtProvider.getClaims(token);

       String username = (String)claims.get("username");
       String role = (String)claims.get("role");
        System.out.println(username);
        System.out.println(role);
    }

    @Test
    void getAuthentication() {
        
        
    }

    @Test
    void validateToken() {
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJoYWpoaTc4OTlAZ21haWwuY29tIiwiaWF0IjoxNzI2MTIzNzYyLCJleHAiOjE3MjYxMjM3NjIsInVzZXJuYW1lIjoiYTIyMyIsI23vbGUiOiJBRE1JTiJ9.umPYKxOFQRFzWKjscR74LC-muvohfH-VZ3zA8BU7Y5Y";
        try{
            jwtProvider.validateToken(token);
            System.out.println("토큰 이상없음");
        } catch (Exception e) {
            System.out.println(e.getMessage());  
        }
        
        
        
    }

    @Test
    void getIssur() {
    }

    @Test
    void getSecretKey() {
    }
}