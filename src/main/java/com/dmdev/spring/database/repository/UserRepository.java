package com.dmdev.spring.database.repository;

import com.dmdev.spring.database.pool.ConnectionPool;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class UserRepository{
    ConnectionPool connectionPool;

    public UserRepository(ConnectionPool pool2) {
        this.connectionPool = pool2;
    }
}
