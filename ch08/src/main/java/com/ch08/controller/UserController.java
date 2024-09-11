package com.ch08.controller;

import com.ch08.dto.UserDTO;
import com.ch08.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final PasswordEncoder encoder;

    @GetMapping("/user/login")
    public String login(){

        return "/user/login";}

//    @PostMapping("/user/login")
//    public String login(UserDTO userDTO, Model model){
//        UserDTO user = userService.loginUser(userDTO);
//        model.addAttribute("user", user);
//        return "redirect:/index";}

    @GetMapping("/user/success")
    public String success(){
        return "/user/success";
    }


    @GetMapping("/user/register")
    public String register(){

        return "/user/register";}

    @PostMapping("/user/register")
    public String register(UserDTO userDTO){
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        userService.insertUser(userDTO);
        return "redirect:/user/login";}
}
