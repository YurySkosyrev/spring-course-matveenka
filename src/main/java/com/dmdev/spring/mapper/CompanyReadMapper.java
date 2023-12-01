package com.dmdev.spring.mapper;

import com.dmdev.spring.dto.CompanyReadDTO;
import com.dmdev.spring.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDTO>{
    @Override
    public CompanyReadDTO map(Company object) {
        return new CompanyReadDTO(
                object.getId(),
                object.getName()
        );
    }
}
