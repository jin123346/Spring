package com.ch05.config;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


//webapp이 처음설정 구동될때 시작하는 class

public class MyWebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 스프링 mvc애플리케이션 컨텍스트 생성
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        //스프링  MVC 구성 클래스 등록
        context.register(AppConfig.class);

        //dispatcherServlet 생성/등록
        DispatcherServlet dispatcherServlet=new DispatcherServlet(context);
        ServletRegistration.Dynamic servletRegistration
                            = servletContext.addServlet("dispatcherServlet", dispatcherServlet);

        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");






    }

}
