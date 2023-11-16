package com.dmdev.spring.config;

import com.dmdev.spring.config.condition.JPACondition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Conditional(JPACondition.class)
@Configuration
public class JPAConfiguration {

//    @Bean
//    @ConfigurationProperties(prefix = "db")
//    public DatabaseProperties databaseProperties(){
//        return new DatabaseProperties();
//    }

    @PostConstruct
    public void init(){
        System.out.println("JPA configuration is enabled");
    }
}
