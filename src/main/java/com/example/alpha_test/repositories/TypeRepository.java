package com.example.alpha_test.repositories;

import com.example.alpha_test.entities.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends CrudRepository<Type, Long> {
    List<Type> findAll();
    Type getById(Long id);
}