package com.example.alpha_test.controllers;

import com.example.alpha_test.beans.Type;
import com.example.alpha_test.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
class TypeController {

    @Autowired
    private TypeRepository repository;

    TypeController(TypeRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/types")
    List<Type> all() {
        return repository.findAll();
    }

    @PostMapping("/types")
    Type newProductType(@RequestBody Type newProductType) {
        return repository.save(newProductType);
    }

    // Single item

    @GetMapping("/types/{id}")
    Optional<Type> one(@PathVariable Long id) {

        return repository.findById(id);
    }


    @PutMapping("/types")
    ResponseEntity<?> addType(@RequestParam Long id,
                                 @RequestParam String name
    ) {
        Type type=new Type();
        type.setId(id);
        type.setName(name);

        return new ResponseEntity<>(repository.save(type), HttpStatus.OK);
    }

    @DeleteMapping("/types/{id}")
    void deleteProductType(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
