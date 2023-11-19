package com.dmdev.spring.integration.service;

import com.dmdev.spring.config.DatabaseProperties;
import com.dmdev.spring.dto.CompanyReadDTO;
import com.dmdev.spring.entity.Company;
import com.dmdev.spring.integration.annotation.IT;
import com.dmdev.spring.listener.entity.EntityEvent;
import com.dmdev.spring.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationRunner.class, initializers = ConfigDataApplicationContextInitializer.class)
@IT
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class CompanyServiceIT {

    private static final Integer COMPANY_ID = 1;


    private final CompanyService companyService;
    private final DatabaseProperties databaseProperties;

    public CompanyServiceIT(CompanyService companyService, DatabaseProperties databaseProperties) {
        this.companyService = companyService;
        this.databaseProperties = databaseProperties;
    }

    @Test
    void findById(){

        Optional<CompanyReadDTO> actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        CompanyReadDTO expectedResult = new CompanyReadDTO(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

    }
}
