package com.dmdev.spring.database.pool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("pool1")
@Slf4j
public class ConnectionPool {
    private final String name;
    private final Integer poolSize;


    public ConnectionPool(@Value("${db.username}") String name, @Value("${db.pool.size}") Integer poolSize) {
        this.name = name;
        this.poolSize = poolSize;
    }

    @PostConstruct
    private void init() {
        log.info("ConnectionPool Initialisation");
    }

    @PreDestroy
    private void destroy() {
        log.info("Destroy ConnectionPool");
    }
}
