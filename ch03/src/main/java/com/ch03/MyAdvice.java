package com.ch03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


//a부가기능을 aspect로 만듬
@Aspect
@Component
public class MyAdvice {


    //pointcut 정의 - 핵심 관심
    // method명은 마음대로  pointcut 으로 내가 지정하고 싶은 핵심관심을 메서드로 정의해주고, 그것에 대한 before,
    @Pointcut("execution(void com.ch03.MyService.insert())")
    public void insertPointCut(){} //핵심관심을 가르키는 내용이 없는 메서드

    //..은 모든 매개변수를 뜻함 , 매개변수가 있다면 그것도 point 에 적어줘야한다.
    @Pointcut("execution(void com.ch03.MyService.select(..))")
    public void selectPointcut(){}


    @Before("insertPointCut() || selectPointcut()")
    public void beforeAdvice() {
        System.out.println("부가기능 - beforeAdvice");
    }

    @After("insertPointCut()")  // pointcut실행 다음
    public void afterAdvice() {
        System.out.println("부가기능 - afterAdvice" );
    }



    @AfterReturning("insertPointCut()")  //after가 있다면 after 이전에
    public void afterReturningAdvice() {
        System.out.println("부가기능 - afterReturningAdvice");

    }

    @AfterThrowing("selectPointcut()")
    public void afterThrowingAdvice() {
        System.out.println("부가기능 - afterThrowingAdvice" );
    }


    @Around("insertPointCut()")
    public void aroundAdvice(ProceedingJoinPoint pjp   ) throws Throwable {

        System.out.println("부가기능 - aroundAdvice1" );
        pjp.proceed();
        System.out.println("부가기능 - aroundAdvice2" );

    }



}
