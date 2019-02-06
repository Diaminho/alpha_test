package com.example.alpha_test.shop.repositories;

import com.example.alpha_test.shop.beans.ProductToProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductToPropertyRepository extends JpaRepository<ProductToProperty, Long> {
}
