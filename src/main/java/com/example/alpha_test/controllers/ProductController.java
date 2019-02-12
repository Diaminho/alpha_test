package com.example.alpha_test.controllers;

import com.example.alpha_test.entities.*;
import com.example.alpha_test.repositories.*;
import com.example.alpha_test.services.implementations.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @GetMapping("/products")
    ResponseEntity<List<Product>> getAllProducts() {
        return productServiceImpl.findAll();
    }

    @PutMapping("/products")
    ResponseEntity<?> addOrChangeProduct(@RequestParam Long id,
                                         @RequestParam String model,
                                         @RequestParam Long brandId,
                                         @RequestParam Long typeId,
                                         @RequestParam Long quantity,
                                         @RequestParam Double price)
    {
        return productServiceImpl.addOrChangeProduct(id, model, brandId, typeId, quantity, price);
    }

    @GetMapping("/products/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productServiceImpl.getProductById(id);
    }

    @DeleteMapping("/products/{id}")
    ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
       return productServiceImpl.deleteProductById(id);
    }

    @PutMapping("/products/{id}/price")
    ResponseEntity<Product> editPrice(@PathVariable Long id, @RequestParam Double newPrice){
        return productServiceImpl.editPrice(id, newPrice);
    }

    @PutMapping("/products/{id}/quantity")
    ResponseEntity<Product> editQuantity(@PathVariable Long id, @RequestParam Long newQuantity){
        return productServiceImpl.editQuantity(id,newQuantity);
    }

    @PutMapping("/products/{id}/BrandName")
    ResponseEntity<Product> editBrandNameId(@PathVariable Long id, @RequestParam Long newBrandNameId){
        return productServiceImpl.editBrandNameId(id, newBrandNameId);
    }

    @PutMapping("/products/{id}/type")
    ResponseEntity<Product> editTypeId(@PathVariable Long id, @RequestParam Long newTypeId){
        return productServiceImpl.editTypeId(id, newTypeId);
    }

    //need to change
    /*@PutMapping("products/{id}/productToProperties/{prodToProp_id}")
    ResponseEntity<?> changeProductToPropertyValue(@PathVariable Long id,@PathVariable Long prodToProp_id, @RequestParam String value, @RequestParam(required = false) Long newPropertyId, @RequestParam(required = false) String newPropertyName){
        Product product=productRepository.findById(id).orElse(null);
        ProductToProperty productToProperty=productToPropertyRepository.findById(prodToProp_id).orElse(null);

        if (product!=null && productToProperty!=null){
            productToProperty.setPropertyValue(value);

            if (newPropertyId!=null) {
                Property property =propertyRepository.findById(newPropertyId).orElse(null);

                if (property!=null) {
                    property.setId(newPropertyId);
                    property.setName(newPropertyName);
                    property.setType_id(product.getProductType().getId());
                    productToProperty.setProperty(property);
                }
            }
            return new ResponseEntity<>(productToPropertyRepository.save(productToProperty), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }*/
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
