package com.example.alpha_test.shop.controllers;

import com.example.alpha_test.shop.beans.Type;
import com.example.alpha_test.shop.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
class ProductTypeController {

    @Autowired
    private TypeRepository repository;

    ProductTypeController(TypeRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/productTypes")
    List<Type> all() {
        return repository.findAll();
    }

    @PostMapping("/productTypes")
    Type newProductType(@RequestBody Type newProductType) {
        return repository.save(newProductType);
    }

    // Single item

    @GetMapping("/productTypes/{id}")
    Optional<Type> one(@PathVariable Long id) {

        return repository.findById(id);
    }

   /* @PutMapping("/productTypes/{id}")
    Type replaceProductType(@RequestBody Type newProductType, @PathVariable int id) {

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
*/
    @DeleteMapping("/productTypes/{id}")
    void deleteProductType(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
