package com.dmdev.spring.dto;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public interface PersonalInfoIfc {
    String getFirstname();

    String getLastname();

    LocalDate getBirthDate();

    @Value("#{target.firstname + ' ' + target.lastname}")
    String getFullName();
}
