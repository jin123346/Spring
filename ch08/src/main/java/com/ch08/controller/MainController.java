package com.ch08.controller;


import com.ch08.security.MyUserDetails;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Log4j2
@Controller
public class MainController {

    @GetMapping(value={"/","index"})
    public String index(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
        if (userDetails != null) {
            // 사용자 정보 로그 출력
            log.info("Authenticated user: " + userDetails.toString());

            // 사용자 정보를 모델에 추가
            model.addAttribute("user", userDetails.getUser());
        } else {
            log.info("No authenticated user found.");
        }
        return "index";
    }

    @GetMapping(value={"/admin","/admin/index"})
    public String admin(){return "/admin/index";}

    @GetMapping(value={"/manager","/manager/index"})
    public String manager(){return "/manager/index";}

    @GetMapping(value={"/staff","/staff/index"})
    public String staff(){return "/staff/index";}



}
