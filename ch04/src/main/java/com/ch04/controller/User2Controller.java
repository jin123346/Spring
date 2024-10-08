package com.ch04.controller;

import com.ch04.dto.User2DTO;
import com.ch04.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User2Controller {

    private User2Service  service;

    @Autowired
    public User2Controller(User2Service service) {
        this.service = service;
    }


    /*register*/
    @GetMapping("/user2/register")
    public String register(){
        System.out.println("register");
        return "/user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO dto){
        System.out.println(dto);
        service.insertUser2(dto);
        return "redirect:/user2/list";
    }


    /*list*/
    @GetMapping("/user2/list")
    public String list(Model model){
        List<User2DTO> user2s = service.selectUsers2();
        System.out.println(user2s);
        model.addAttribute("user2s",user2s); // user2DTO
        return "/user2/list";
    }


    /*modify*/
    @GetMapping("/user2/modify")
    public String modify(User2DTO dto, Model model){
        System.out.println("uid :"+dto.getUid());

        User2DTO user2DTO= service.selectUser2(dto.getUid());
        model.addAttribute("user2",user2DTO);
        return "/user2/modify";
    }
    @PostMapping("/user2/modify")
    public String modify(User2DTO dto){
        System.out.println(dto);
        service.updateUser2(dto);

        return "redirect:/user2/list";
    }

    /*delete*/
    @GetMapping("/user2/delete")
    public String delete(@RequestParam("uid") String uid){
        System.out.println("uid : "+uid);
        service.deleteUser2(uid);
        return "redirect:/user2/list";

    }
}
