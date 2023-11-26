package com.dmdev.spring.database.repository;

import com.dmdev.spring.database.querydsl.QPredicates;
import com.dmdev.spring.dto.UserFilter;
import com.dmdev.spring.entity.User;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import java.util.List;

import static com.dmdev.spring.entity.QUser.user;

public class FilterUserRepositoryImpl implements FilterUserRepository{

    private final EntityManager entityManager;

    public FilterUserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAllByFilter(UserFilter filter) {

        Predicate predicate = QPredicates.builder()
                .add(filter.firstname(), user.firstname::containsIgnoreCase)
                .add(filter.lastname(), user.lastname::containsIgnoreCase)
                .add(filter.birthDate(), user.birthDate::before)
                .build();

        return new JPAQuery<User>(entityManager)
                .select(user)
                .from(user)
                .where(predicate)
                .fetch();

    }
}
