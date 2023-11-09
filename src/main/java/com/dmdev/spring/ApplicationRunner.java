package com.dmdev.spring;

import com.dmdev.spring.database.repository.CompanyRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        System.out.println(context.getBean(CompanyRepository.class));
    }
}
