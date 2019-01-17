package com.example.alpha_test.shop.controllers;

import com.example.alpha_test.shop.ProductType;
import com.example.alpha_test.shop.repositories.ProductTypeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
class ProductTypeController {

    private ProductTypeRepository repository;

    ProductTypeController(ProductTypeRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/productTypes")
    List<ProductType> all() {
        return repository.findAll();
    }

    @PostMapping("/productTypes")
    ProductType newProductType(@RequestBody ProductType newProductType) {
        return repository.save(newProductType);
    }

    // Single item

    @GetMapping("/productTypes/{id}")
    Optional<ProductType> one(@PathVariable Long id) {

        return repository.findById(id);
    }

    @PutMapping("/productTypes/{id}")
    ProductType replaceProductType(@RequestBody ProductType newProductType, @PathVariable int id) {

        return repository.findById((long) id)
                .map(productType -> {
                    productType.setTypeName(newProductType.getTypeName());
                    productType.setId(newProductType.getId());
                    return repository.save(productType);
                })
                .orElseGet(() -> {
                    newProductType.setId(id);
                    return repository.save(newProductType);
                });
    }

    @DeleteMapping("/productTypes/{id}")
    void deleteProductType(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
