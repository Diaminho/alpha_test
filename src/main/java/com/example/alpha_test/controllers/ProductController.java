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

    @GetMapping("/products")
    ResponseEntity<List> all() {
        return new ResponseEntity<List>(productRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/products")
    ResponseEntity<?> addProduct(@RequestParam Long id,
                                 @RequestParam String model,
                                 @RequestParam Long brandId,
                                 @RequestParam Long typeId,
                                 @RequestParam Long quantity,
                                 @RequestParam double price
    ) {
        BrandName brand=brandRepository.findById(brandId).orElse(null);
        Type type=typeRepository.findById(typeId).orElse(null);

        if (brand!=null && type!=null) {

            Product product = new Product();
            product.setBrandNameId(brand);
            product.setId(id);
            product.setModel(model);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setProductTypeId(type);

            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/products/{id}")
    ResponseEntity<Product> one(@PathVariable Long id) {
        Product product=productRepository.findById(id).orElse(null);
        if (product!=null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>((Product)null,HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/products/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/products/{id}/price")
    ResponseEntity<?> editPrice(@PathVariable Long id, @RequestParam double newPrice){
        Product product=productRepository.findById(id).orElse(null);
        if (product!=null) {
            product.setPrice(newPrice);
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/products/{id}/quantity")
    ResponseEntity<?> editQuantity(@PathVariable Long id, @RequestParam Long newQuantity){
        Product product=productRepository.findById(id).orElse(null);
        if (product!=null) {
            product.setQuantity(newQuantity);
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/products/{id}/BrandName")
    ResponseEntity<?> editBrandNameId(@PathVariable Long id, @RequestParam Long newBrandNameId){
        Product product=productRepository.findById(id).orElse(null);
        BrandName brand=brandRepository.findById(newBrandNameId).orElse(null);
        if (product!=null && brand!=null) {
            product.setBrandNameId(brand);
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/products/{id}/type")
    ResponseEntity<?> editTypeId(@PathVariable Long id, @RequestParam Long newTypeId){
        Product product=productRepository.findById(id).orElse(null);
        Type type=typeRepository.findById(newTypeId).orElse(null);
        if (product!=null && type!=null) {
            product.setProductTypeId(type);
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
