package com.example.alpha_test.controllers;

import com.example.alpha_test.entities.*;
import com.example.alpha_test.services.implementations.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    //Service
    @Autowired
    private ProductServiceImpl productServiceImpl;

    //default constructor
    ProductController() { }

    //getting all products
    @GetMapping(value={"/products", "/"})
    ResponseEntity<List<Product>> getAllProducts() {
        return productServiceImpl.findAll();
    }

    //changing existing product with id={id}
    @PutMapping("/products/{id}")
    ResponseEntity<Product> changeProduct(@PathVariable Long id,
                                         @RequestParam String model,
                                         @RequestParam Long brandId,
                                         @RequestParam Long typeId,
                                         @RequestParam Long quantity,
                                         @RequestParam Double price)
    {
        return productServiceImpl.putProduct(id, model, brandId, typeId, quantity, price);
    }

    //adding product
    @PutMapping("/products")
    ResponseEntity<Product> addProduct(@RequestParam Long id,
                                          @RequestParam String model,
                                          @RequestParam Long brandId,
                                          @RequestParam Long typeId,
                                          @RequestParam Long quantity,
                                          @RequestParam Double price)
    {
        return productServiceImpl.putProduct(id, model, brandId, typeId, quantity, price);
    }

    //getting product with id={id}
    @GetMapping("/products/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productServiceImpl.getProductById(id);
    }

    //deleting product by id
    @DeleteMapping("/products/{id}")
    ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
       return productServiceImpl.deleteProductById(id);
    }

    //changing price of product with id={id}
    @PutMapping("/products/{id}/price")
    ResponseEntity<Product> editPrice(@PathVariable Long id, @RequestParam Double newPrice){
        return productServiceImpl.editPrice(id, newPrice);
    }

    //changing quantity of product with id={id}
    @PutMapping("/products/{id}/quantity")
    ResponseEntity<Product> editQuantity(@PathVariable Long id, @RequestParam Long newQuantity){
        return productServiceImpl.editQuantity(id,newQuantity);
    }

    //changing brandName of product with id={id}
    @PutMapping("/products/{id}/brandName")
    ResponseEntity<Product> editBrandNameId(@PathVariable Long id, @RequestParam Long newBrandNameId){
        return productServiceImpl.editBrandNameId(id, newBrandNameId);
    }

    //changing type of product with id={id}
    @PutMapping("/products/{id}/type")
    ResponseEntity<Product> editTypeId(@PathVariable Long id, @RequestParam Long newTypeId){
        return productServiceImpl.editTypeId(id, newTypeId);
    }

    //changing property value
    @PutMapping("products/{id}/productToProperties/{productToPropertyId}/property/{propertyId}")
    ResponseEntity<Product> editPropertyIdAndValue(@PathVariable Long id, @PathVariable Long productToPropertyId, @PathVariable Long propertyId, @RequestParam String value){
        return productServiceImpl.editPropertyIdAndValue(id,productToPropertyId, propertyId,value);
    }
    //

    /*
    @GetMapping("brandNames")
    ResponseEntity<List> getBrands(){
        return new ResponseEntity<>(brandRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("types")
    ResponseEntity<List<Type>> getTypes(){
        return typeServiceImpl.findAll();
    }

    @GetMapping("properties")
    ResponseEntity<List> getProperties(){ return new ResponseEntity<>(propertyRepository.findAll(),HttpStatus.OK); }
    */
}
