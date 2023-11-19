package com.dmdev.spring.integration.service;

import com.dmdev.spring.database.pool.ConnectionPool;
import com.dmdev.spring.integration.annotation.IT;
import com.dmdev.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

@IT
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserServiceIT {

    @Autowired
    private UserService userService;

    @Autowired
    private ConnectionPool pool1;

    @Test
    void test1(){

    }

    @Test
    void test2(){

    }

}
