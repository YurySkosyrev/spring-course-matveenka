package com.dmdev.spring;

import com.dmdev.spring.database.repository.CompanyRepository;
import com.dmdev.spring.database.repository.CrudRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {
            CrudRepository  companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}
