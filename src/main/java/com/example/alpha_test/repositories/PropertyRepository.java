package com.example.alpha_test.repositories;

import com.example.alpha_test.entities.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {
    List<Property> findAll();
}
