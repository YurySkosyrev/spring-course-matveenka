package com.dmdev.spring.database.pool;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

public class ConnectionPool {
    private final String name;
    private final Integer poolSize;
    private final List<Object> args;
    private Map<String, Object> properties;

    public ConnectionPool(String name, Integer poolSize, List<Object> args, Map<String, Object> properties) {
        this.name = name;
        this.poolSize = poolSize;
        this.args = args;
        this.properties = properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
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
