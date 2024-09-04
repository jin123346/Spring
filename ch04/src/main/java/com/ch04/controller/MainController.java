package com.ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {


    //연결받아올 파일을 매핑해줌 // 기본  method는 get
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        System.out.println("hello....");
        return "hello";
    }

    @GetMapping(value = "/welcome")
    public String welcome(){
        System.out.println("welcome....");
        return "welcome";
    }
    @GetMapping(value="/greeting")
    public String greeting(){
        System.out.println("greeting....");
        return "greeting";

    }
}
