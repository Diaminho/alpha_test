package com.example.alpha_test.shop;

import com.example.alpha_test.shop.repositories.ProductTypeRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ProductTypeRepository repository) {
        return args -> {
            repository.save(new ProductType(1,"TV"));
            repository.save(new ProductType(2,"Fridge"));
        };
    }
}
