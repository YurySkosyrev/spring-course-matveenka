package com.dmdev.spring;

import com.dmdev.spring.config.ApplicationConfiguration;
import com.dmdev.spring.database.repository.CompanyRepository;
import com.dmdev.spring.database.repository.CrudRepository;
import com.dmdev.spring.database.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()){
            context.register(ApplicationConfiguration.class);
            context.getEnvironment().setActiveProfiles("web", "prod");
            context.refresh();
            CrudRepository  companyRepository = context.getBean("companyRepository", CrudRepository.class);
            CrudRepository userRepository = context.getBean("userRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}
