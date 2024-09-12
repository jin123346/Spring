package com.ch09.controller;


import com.ch09.dto.User1DTO;
import com.ch09.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service user1Service;

    @ResponseBody
    @GetMapping("/user1/")
    public List<User1DTO> list(){
        List<User1DTO> users = user1Service.selectUser1s();
        return users;
    }

    @ResponseBody
    @GetMapping("/user1/{uid}")
    public User1DTO user(@PathVariable("uid") String uid){
        User1DTO user1 = user1Service.selectUser1(uid);

        return user1;
    }

    @ResponseBody
    @PostMapping("/user1")
    public ResponseEntity register(@Validated @RequestBody User1DTO userdto){
        log.info("User registration: {}", userdto);
        User1DTO savedUser1 = user1Service.insertUser1(userdto);  // 데이터 저장 로직 추가

        //응답객체
       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(savedUser1);

    }
    @PutMapping("/user1/")
    public ResponseEntity modify(@RequestBody User1DTO userdto){
        log.info("User modify: {}", userdto);
        User1DTO modifiedUser1 =  user1Service.updateUser1(userdto);


        //responseentity로 변환할 경우 @ResponseBody생략 가능
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(modifiedUser1);
    }



    @DeleteMapping("/user1/{uid}")
    public ResponseEntity delete(@PathVariable("uid") String uid){
        try{
            user1Service.deleteUser1(uid);
            return ResponseEntity.status(HttpStatus.OK).body("success");
         }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }


    }
}
