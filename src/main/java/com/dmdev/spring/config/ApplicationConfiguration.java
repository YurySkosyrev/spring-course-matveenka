package com.dmdev.spring.config;

import com.dmdev.spring.database.pool.ConnectionPool;
import com.dmdev.spring.database.repository.UserRepository;
import com.dmdev.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Import(WebConfiguration.class)
@Configuration(proxyBeanMethods = true)
public class ApplicationConfiguration {

    @Bean
//    @Profile("prod|web")
    public ConnectionPool pool2(@Value("${db.username}")String username) {
        return new ConnectionPool(username, 66);
    }

    @Bean
    public ConnectionPool pool3() {
        return new ConnectionPool("test-pool", 10);
    }
}
