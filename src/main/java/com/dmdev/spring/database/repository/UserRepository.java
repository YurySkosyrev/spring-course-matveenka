package com.dmdev.spring.database.repository;

import com.dmdev.spring.database.pool.ConnectionPool;
import com.dmdev.spring.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository implements CrudRepository<Integer, Company>{
    ConnectionPool connectionPool;

    public UserRepository(ConnectionPool pool2) {
        this.connectionPool = pool2;
    }

    @Override
    public Optional<Company> findById(Integer key) {
        return Optional.empty();
    }

    @Override
    public void delete(Company entity) {

    }
}
