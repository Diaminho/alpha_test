package com.example.alpha_test.repository;

import com.example.alpha_test.entity.BrandName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandNameRepository extends CrudRepository<BrandName, Long> {
    List<BrandName> findAll();
    BrandName getById(Long id);
}
