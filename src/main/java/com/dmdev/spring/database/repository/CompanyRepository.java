package com.dmdev.spring.database.repository;

import com.dmdev.spring.bpp.InjectBean;
import com.dmdev.spring.bpp.Transaction;
import com.dmdev.spring.database.pool.ConnectionPool;
import com.dmdev.spring.entity.Company;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Transaction
public class CompanyRepository implements CrudRepository<Integer, Company> {
    @InjectBean
    private ConnectionPool connectionPool;
    @InjectBean
    private String name;

    @PostConstruct
    public void init() {
        System.out.println("Init Company Repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method...");
    }
}
