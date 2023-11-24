package com.dmdev.spring.integration.database.repository;

import com.dmdev.spring.database.repository.UserRepository;
import com.dmdev.spring.entity.Role;
import com.dmdev.spring.entity.User;
import com.dmdev.spring.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void checkFind(){
        List<User> users = userRepository.findAllBy("a", "ov");
        Assertions.assertThat(users).hasSize(3);
        System.out.println(users);
    }

    @Test
    void checkUpdate(){

        User user = userRepository.getById(1L);
        assertSame(Role.ADMIN, user.getRole());

        int result = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2, result);

        User sameUser = userRepository.getById(1L);
        assertSame(Role.USER, sameUser.getRole());
    }

}