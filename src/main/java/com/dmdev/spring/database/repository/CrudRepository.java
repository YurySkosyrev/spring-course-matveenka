package com.dmdev.spring.database.repository;

import java.util.Optional;

public interface CrudRepository <K, E>{
    Optional<E> findById(K key);
    void delete(E entity);
}
