package com.ch02.config;

import com.ch02.sub1.Greeting;
import com.ch02.sub1.Hello;
import com.ch02.sub1.Welcome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ch02"})
public class AppConfig {
    //app 의 Scan config  컨테이너에 등록할 객체들을 지정함
    //이 패키지의 설정파일이됨
    
    //객체 생성의 두가지방법 
    /*
        1. configuration에서 bean anotation을 이용하여 객체를 생성하는 방법'
        2. componont 안에서 autoweired를 통해 필드주입, 생성자주입, setter주입 방법으로 객체 생성
        3. aop를 이용하여
     */

    //Bean을 사용하여, 사용할 객체를 container 에 등록해줌
    @Bean
    public Hello hello() {
        return new Hello();
    }

    //name 은 생략되어도 괜찮다.
    @Bean(name = "welcome")
    public Welcome welcome() {
        return new Welcome();

    }

    // 객체의 이름을 미리 설정해줄 수 있음
    @Bean("greet")
    public Greeting greeting() {
        return new Greeting();

    }

    //Bean  등록방법은 여러가지있다. sub1, sub2방법







}
