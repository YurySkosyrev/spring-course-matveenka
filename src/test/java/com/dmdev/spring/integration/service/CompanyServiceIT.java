package com.dmdev.spring.integration.service;

import com.dmdev.spring.config.DatabaseProperties;
import com.dmdev.spring.dto.CompanyReadDTO;
import com.dmdev.spring.integration.annotation.IT;
import com.dmdev.spring.service.CompanyService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        CompanyReadDTO expectedResult = new CompanyReadDTO(COMPANY_ID, null);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

    }
}
