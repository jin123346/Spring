package com.ch09.controller;

import com.ch09.dto.User1DTO;
import com.ch09.dto.User2DTO;
import com.ch09.service.User2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class User2Controller {
/*
    @RestController를 어노테이션 해주는 경우,  @responseBody는 생략해줘도 된다.
RestAPI 용 컨트롤러 어노테이션
 */


    private final User2Service user2Service;


    @GetMapping("/user2/")
    public List<User2DTO> list() {

        return user2Service.selectUser2s();
    }


    @GetMapping("/user2/{uid}")
    public User2DTO user(@PathVariable("uid") String uid){
        User2DTO user2 = user2Service.selectUser2(uid);

        return user2;
    }

    @PostMapping("/user2/")
    public ResponseEntity register(@RequestBody User2DTO user2){

        User2DTO savedUser2 = user2Service.InsertUser2(user2);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser2);
    }

    @PutMapping("/user2/")
    public ResponseEntity modify(@RequestBody User2DTO user2){

        User2DTO updateUser2 = user2Service.updateUser2(user2);
        return ResponseEntity.status(HttpStatus.OK).body(updateUser2);


    }



    @DeleteMapping("/user2/{uid}")
    public ResponseEntity delete(@PathVariable("uid") String uid){
        try{
            user2Service.deleteUser2(uid);
            return ResponseEntity.status(HttpStatus.OK).body("success");
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }    }
}
