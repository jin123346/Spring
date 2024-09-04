package com.ch03.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.ch03"})
@EnableAspectJAutoProxy
public class AppConfig {
    //componentScan 을 통해 생성된 컴포넌트들을 찾아옴

}
