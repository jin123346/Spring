package com.ch03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MyService {


//    객체지향
//    @Autowired
//    private MyAdvice advice;

    public void insert(){
        //advice.beforeAdvice();  - 객체지향방식
        System.out.println("핵심기능 - insert method");
    }
    public void select(){
        System.out.println("핵심기능 - select method");

    }


    public void select(String uid){

        System.out.println("핵심기능 - select method");
        if(uid.equals("a101")){
            System.out.println("핵심기능 - uid : "+uid);
        }
    }


    public void update(){
        System.out.println("핵심기능 - update method");

    }
    public void delete(){
        System.out.println("핵심기능 - delete method");

    }


}
