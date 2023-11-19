package com.dmdev.spring.service;

import com.dmdev.spring.database.repository.CrudRepository;
import com.dmdev.spring.database.repository.UserRepository;
import com.dmdev.spring.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;
}