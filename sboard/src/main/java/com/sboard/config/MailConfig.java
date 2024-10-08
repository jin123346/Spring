package com.sboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Properties;

@Configuration
public class MailConfig {


    @Value("${spring.mail.host}")
    private String mailServerHost;
    @Value("${spring.mail.port}")
    private String mailServerPort;
    @Value("${spring.mail.username}")
    private String mailServerUsername;
    @Value("${spring.mail.password}")
    private String mailServerPassword;


    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailServerHost);
        mailSender.setPassword(mailServerPort);

        mailSender.setUsername(mailServerUsername);
        mailSender.setPassword(mailServerPassword);

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        return mailSender;
    }



}
