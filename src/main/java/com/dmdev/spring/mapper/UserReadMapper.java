package com.dmdev.spring.mapper;

import com.dmdev.spring.dto.CompanyReadDTO;
import com.dmdev.spring.dto.UserReadDto;
import com.dmdev.spring.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto>{

    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto map(User object) {

        CompanyReadDTO companyReadDTO = Optional.ofNullable(object.getCompany())
                .map(companyReadMapper::map)
                .orElse(null);

        return new UserReadDto(
                object.getId(),
                object.getUsername(),
                object.getBirthDate(),
                object.getFirstname(),
                object.getLastname(),
                object.getRole(),
                companyReadDTO
        );
    }
}
