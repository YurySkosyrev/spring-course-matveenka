package com.dmdev.spring.database.repository;

import com.dmdev.spring.dto.UserFilter;
import com.dmdev.spring.entity.User;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter filter);
}
