package com.ch10.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  //모든 요청 주소에 대해 접근 허용
                .allowedOriginPatterns("http://127.0.0.1:5501")  //모든 origin에서의 요청 허용하지 않고 지정해서 허용해야함
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //허용할 method 설정
                .allowedHeaders("*")  // 모든 헤더 정보 허용
                .allowCredentials(true) // 자격증명 허용
                .maxAge(3600);  //요청유효기간  pre-flight 요청의 유효시간 설정

    }




}
