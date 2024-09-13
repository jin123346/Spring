package com.ch10.controller;


import com.ch10.dto.UserDTO;
import com.ch10.entity.User;
import com.ch10.jwt.JwtProvider;
import com.ch10.security.MyUserDetails;
import com.ch10.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Log4j2
@RequiredArgsConstructor
@RestController
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity user(Authentication authentication) {

        log.info("user1 : "+authentication.getPrincipal());


            User user = (User) authentication.getPrincipal();

            log.info("user3 : "+user);

            UserDTO userDTO = userService.selectUser(user.getUsername());
            userDTO.setPassword(null);
            return ResponseEntity.ok().body(userDTO);




    }



    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody  UserDTO user) {
        log.info("login1 - "+user);

        try {

            UsernamePasswordAuthenticationToken authToken
                    = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            //token을 컨트롤러에서 만들어서 auth manager에 넣어줘야함

            //인증처리완
            Authentication authentication = authenticationManager.authenticate(authToken);
            log.info("login2 - "+authentication);


            //인증된 사용자 객체 가져오기
            //에러 발생가능 0 =>  인증실패시 null

            MyUserDetails myUserDetails=(MyUserDetails) authentication.getPrincipal();
            log.info("login3 - "+myUserDetails);
            User myUser =  myUserDetails.getUser();
            log.info("login4 - "+myUser);
            String accessToken = jwtProvider.createToken(myUser,1);
            log.info("login5 - "+accessToken);
            String refreshToken = jwtProvider.createToken(myUser,7);

            //리프레쉬 토큰 db저장(refresh)

            //client에 토큰 전송(access,refresh)
            Map <String,Object> result = new HashMap<>();
            result.put("accessToken",accessToken);
            result.put("refreshToken",refreshToken);
            result.put("token_type","Bearer");
            log.info("login6 - "+result);

            return ResponseEntity
                    .ok()
                    .body(result);


        } catch (Exception e) {
            //인증실패
            log.info("login7 - catch");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("user not found");

        }






    }

}
