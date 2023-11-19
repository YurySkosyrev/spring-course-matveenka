package com.dmdev.spring.service;

import com.dmdev.spring.database.repository.CrudRepository;
import com.dmdev.spring.dto.CompanyReadDTO;
import com.dmdev.spring.entity.Company;
import com.dmdev.spring.listener.entity.AccessType;
import com.dmdev.spring.listener.entity.EntityEvent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompanyService {

    private final CrudRepository<Integer, Company> companyRepository;
    private final ApplicationEventPublisher publisher;

    public CompanyService(@Qualifier(value = "companyRepository") CrudRepository<Integer, Company> companyRepository,
                          ApplicationEventPublisher publisher) {
        this.companyRepository = companyRepository;
        this.publisher = publisher;
    }

    public Optional<CompanyReadDTO> findById(Integer id) {
        return companyRepository.findById(id).
        map(entity -> {
            publisher.publishEvent(new EntityEvent(entity, AccessType.READ));
            return new CompanyReadDTO(entity.getId());
        });
    }
}
