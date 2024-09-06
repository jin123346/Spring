package com.ch06.controller;

import com.ch06.dto.User1DTO;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Log4j2 //logger 어노테이션
@Controller
public class MainController {



    @GetMapping(value={"/index","/"})
    public String index(Model model){
        String str1 = "Hello World";
        String str2 = "Hello Spring boot!";

        //dto 생성 - 생성자초기화
        User1DTO user1 = new User1DTO("a111","김유신","1996-01-01","010-1223-1223",21);

        log.info(user1);

        //DTO 생성 - 세터 초기화
        User1DTO user2 = new User1DTO();
        user2.setUid("a222");
        user2.setName("장보고");
        user2.setBirth("1999-9-9");
        user2.setHp("010-1234-1234");
        user2.setAge(23);

        log.info(user2);

        //DTO생성 -빌더 초기화
         User1DTO user3 = User1DTO.builder()
                 .uid("a333")
                 .name("깅땡땡")
                 .birth("1996-01-01")
                 .hp("010-1244-1244")
                 .age(45)
                 .build();
        log.info(user3);


        List<User1DTO> user1s = new ArrayList<>();
        user1s.add(user1);
        user1s.add(user2);
        user1s.add(user3);

        model.addAttribute("user1s", user1s);

        model.addAttribute("user1", user1);
        model.addAttribute("user2", user2);
        model.addAttribute("user3",user3);
        model.addAttribute("str1", str1);
        model.addAttribute("str2", str2);

        return "index";
    }

    @GetMapping("/sub01/hello")
    public String hello(){
        return "/sub01/hello";
    }
    @GetMapping("/sub01/greeting")
    public String greeting(){
        return "/sub01/greeting";
    }
    @GetMapping("/sub01/welcome")
    public String welcome(){
        return "/sub01/welcome";
    }


}
