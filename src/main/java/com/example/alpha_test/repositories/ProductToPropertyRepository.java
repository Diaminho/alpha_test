package com.example.alpha_test.repositories;

import com.example.alpha_test.entities.ProductToProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductToPropertyRepository extends CrudRepository<ProductToProperty, Long> {
    List findAll();
}
