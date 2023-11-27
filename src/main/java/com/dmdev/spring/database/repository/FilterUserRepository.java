package com.dmdev.spring.database.repository;

import com.dmdev.spring.dto.PersonalInfo;
import com.dmdev.spring.dto.UserFilter;
import com.dmdev.spring.entity.Role;
import com.dmdev.spring.entity.User;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter filter);

    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);

    void updateCompanyAndRole(List<User> users);

    void updateCompanyAndRoleNamed(List<User> users);
}
