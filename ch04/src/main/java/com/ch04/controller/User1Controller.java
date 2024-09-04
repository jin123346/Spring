package com.ch04.controller;

import com.ch04.dto.User1DTO;
import com.ch04.service.User1Service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User1Controller {

    private User1Service user1Service;

   public User1Controller(User1Service user1Service) {
       this.user1Service = user1Service;
   }

    //매핑주소를  맞추는것이 좋다. 기계적으로
    //CRUD를 생각해서 컨트롤러 기본설계는 이런식으로 하는 것이 좋다.
    @GetMapping("/user1/register")
    public String register(){
        System.out.println("register!!!");
        return "/user1/register";
    }

    @PostMapping("/user1/register") //파라미터 수신해줌 dispatcherServlet이 파라미터를 받아 dto를 자동생성해준다.
    public String register(User1DTO dto){
        System.out.println(dto);
        user1Service.insertUser1(dto);

        return "redirect:/user1/list";
    }
    @GetMapping("/user1/list")
    public String list(Model model){  //jsp에서 reqeust객체와 같은 역할을하는  model을 참조변수로 넣어서 사용

        List<User1DTO> users = user1Service.selectUser1s();
        System.out.println(users);

        //모델 참조(controller 데이터를 view에서 참조
        model.addAttribute("users", users);
        return "/user1/list";
    }
    @GetMapping("/user1/modify")
    public String modify(@RequestParam("uid") String uid, Model model){ //@RequestParam("uid")  생략가능 => getparameter 역할
        System.out.println("uid : "+uid);
        
        //수정할 데이터 불러오기
        User1DTO user = user1Service.selectUser1(uid);

        //모델참조
        model.addAttribute(user); // key이름이 타입명으로 저장(소문자시작) user1DTO 참조시 user1DTO로 사용해야함

        return "/user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(@ModelAttribute User1DTO dto){
        System.out.println(dto);
        user1Service.updateUser1(dto);

        //model.addAttribute(dto);  modelattribute시 자동으로 참조됨
       return "redirect:/user1/list";
    }

    @GetMapping("/user1/delete")
    public String delete(@RequestParam("uid") String uid){
        System.out.println("uid : "+uid);
       user1Service.deleteUser1(uid);
        return "redirect:/user1/list";
    }


}
