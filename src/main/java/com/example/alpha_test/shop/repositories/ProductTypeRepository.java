package com.example.alpha_test.shop.repositories;

import com.example.alpha_test.shop.beans.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<Type, Long> {

}