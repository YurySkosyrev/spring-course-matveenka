package com.dmdev.spring.database.pool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("pool1")
public class ConnectionPool {
    private final String name;
    private final Integer poolSize;


    public ConnectionPool(@Value("${db.username}") String name, @Value("${db.pool.size}") Integer poolSize) {
        this.name = name;
        this.poolSize = poolSize;
    }

    @PostConstruct
    private void init() {
        System.out.println("ConnectionPool Initialisation");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Destroy ConnectionPool");
    }
}
