package com.example.alpha_test.controllers;

import com.example.alpha_test.beans.BrandName;
import com.example.alpha_test.beans.Product;
import com.example.alpha_test.beans.Type;
import com.example.alpha_test.repositories.BrandNameRepository;
import com.example.alpha_test.repositories.ProductRepository;
import com.example.alpha_test.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
 class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private BrandNameRepository brandRepository;

    ProductController() {

    }

    @GetMapping("/products/{id}")
    ResponseEntity<Optional> all(@PathVariable Long id) {
        Optional<Product> product=productRepository.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/products")
    ResponseEntity<?> addProduct(//@RequestParam Long id,
                                 @RequestParam String model,
                                 @RequestParam Long brandId,
                                 @RequestParam Long typeId,
                                 @RequestParam Long quantity,
                                 @RequestParam double price
                                 ) {
        BrandName brand=brandRepository.getOne(brandId);
        Type type=typeRepository.getOne(typeId);

        Product product=new Product();
        product.setBrandNameId(brand);
        //product.setId(id);
        product.setModel(model);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setProductTypeId(type);

        return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
    }
}
