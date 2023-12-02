package com.dmdev.spring.integration.service;

import com.dmdev.spring.dto.UserCreateEditDto;
import com.dmdev.spring.dto.UserReadDto;
import com.dmdev.spring.entity.Role;
import com.dmdev.spring.integration.IntegrationTestBase;
import com.dmdev.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@RequiredArgsConstructor
public class UserServiceIT extends IntegrationTestBase {

    private static final Long USER_1 = 1L;
    private static final Integer COMPANY = 1;

    private final UserService userService;

    @Test
    void findAll() {
        List<UserReadDto> result = userService.findAll();
        assertThat(result).hasSize(5);
    }

    @Test
    void findById(){
        Optional<UserReadDto> maybeUser = userService.findById(USER_1);
        assertTrue(maybeUser.isPresent());
        maybeUser.ifPresent(user ->
                assertEquals("ivan@gmail.com", user.getUsername()));
    }

    @Test
    void create() {
        UserCreateEditDto userCreateEditDto = new UserCreateEditDto(
                "test@gmail.com",
                LocalDate.now(),
                "Test",
                "Test",
                Role.ADMIN,
                COMPANY
        );

        UserReadDto createdUser = userService.create(userCreateEditDto);
        assertEquals(createdUser.getUsername(), userCreateEditDto.getUsername());
        assertEquals(createdUser.getBirthDate(), userCreateEditDto.getBirthDate());
        assertEquals(createdUser.getFirstname(), userCreateEditDto.getFirstname());
        assertEquals(createdUser.getLastname(), userCreateEditDto.getLastname());
        assertEquals(createdUser.getCompany().id(), userCreateEditDto.getCompanyId());
        assertSame(createdUser.getRole(), userCreateEditDto.getRole());
    }

    @Test
    void update() {
        UserCreateEditDto userCreateEditDto = new UserCreateEditDto(
                "test@gmail.com",
                LocalDate.now(),
                "Test",
                "Test",
                Role.ADMIN,
                COMPANY
        );

        Optional<UserReadDto> updatedUser = userService.update(USER_1, userCreateEditDto);

        assertTrue(updatedUser.isPresent());
        updatedUser.ifPresent(user -> {
            assertEquals(user.getUsername(), userCreateEditDto.getUsername());
            assertEquals(user.getBirthDate(), userCreateEditDto.getBirthDate());
            assertEquals(user.getFirstname(), userCreateEditDto.getFirstname());
            assertEquals(user.getLastname(), userCreateEditDto.getLastname());
            assertEquals(user.getCompany().id(), userCreateEditDto.getCompanyId());
            assertSame(user.getRole(), userCreateEditDto.getRole());
        });
    }

    @Test
    void delete(){
        assertTrue(userService.delete(USER_1));
        assertFalse(userService.delete(-123L));
    }
}
