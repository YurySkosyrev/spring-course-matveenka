package com.dmdev.spring.config;

import com.dmdev.spring.config.condition.JPACondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Conditional(JPACondition.class)
@Configuration
public class JPAConfiguration {

    @PostConstruct
    public void init(){
        System.out.println("JPA configuration is enabled");
    }
}
