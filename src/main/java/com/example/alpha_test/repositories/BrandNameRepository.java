package com.example.alpha_test.repositories;

import com.example.alpha_test.entities.BrandName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandNameRepository extends CrudRepository<BrandName, Long> {
    List<BrandName> findAll();
    BrandName getById(Long id);
}
