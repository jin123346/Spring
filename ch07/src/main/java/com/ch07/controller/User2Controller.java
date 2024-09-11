package com.ch07.controller;


import com.ch07.dto.User2DTO;
import com.ch07.service.User2Service;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class User2Controller {

    private final User2Service user2Service;

    @GetMapping("/user2/list")
    public String list(Model model){
        List<User2DTO> user2s = user2Service.selectUser2s();
        log.info(user2s.toString());
        model.addAttribute("user2s", user2s);
        log.info(model.getAttribute("user2s"));
        return "/user2/list";}

    @GetMapping("/user2/register")
    public String register(){

        return "/user2/register";}
    @PostMapping("/user2/register")
    public String register(User2DTO user2DTO){
        user2Service.insertUser2(user2DTO);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(String uid, Model model){
        User2DTO user2dto= user2Service.selectUser2(uid);
        model.addAttribute("user2dto", user2dto);
        return "/user2/modify";}

    @PostMapping("/user2/modify")
    public String modify(User2DTO user2DTO){
        user2Service.updateUser2(user2DTO);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/delete")
    public String delete(String uid){
        user2Service.deleteUser2(uid);
        return "redirect:/user2/list";}




}
