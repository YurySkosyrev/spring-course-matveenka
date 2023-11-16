package com.dmdev.spring.config;

import com.dmdev.spring.database.pool.ConnectionPool;
import com.dmdev.spring.database.repository.CrudRepository;
import com.dmdev.spring.database.repository.UserRepository;
import com.dmdev.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Import(WebConfiguration.class)
@Configuration(proxyBeanMethods = true)
public class ApplicationConfiguration {

    @Bean
//    @Profile("prod|web")
    public ConnectionPool pool2(@Value("${db.username}")String username) {
        return new ConnectionPool(username, 66);
    }

    @Bean
    @Profile("prod|web")
    public UserRepository UserRepository2(ConnectionPool pool1){
        return new UserRepository(pool1);
    }

    @Bean
    public ConnectionPool pool3() {
        return new ConnectionPool("test-pool", 10);
    }

    @Bean
    public UserRepository UserRepository3(ConnectionPool pool3){
        ConnectionPool connectionPool1 = pool3();
        ConnectionPool connectionPool2 = pool3();
        ConnectionPool connectionPool3 = pool3();
        return new UserRepository(pool3);
    }

}
