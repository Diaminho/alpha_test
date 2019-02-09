package com.example.alpha_test.controllers;

import com.example.alpha_test.beans.*;
import com.example.alpha_test.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private BrandNameRepository brandRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ProductToPropertyRepository productToPropertyRepository;

    ProductController() {}

    @GetMapping("/products")
    ResponseEntity<List> getAllProducts() {
        return new ResponseEntity<List>(productRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/products")
    ResponseEntity<?> addOrChangeProduct(@RequestParam Long id,
                                         @RequestParam String model,
                                         @RequestParam Long brandId,
                                         @RequestParam Long typeId,
                                         @RequestParam Long quantity,
                                         @RequestParam double price)
    {
        BrandName brand=brandRepository.findById(brandId).orElse(null);
        Type type=typeRepository.findById(typeId).orElse(null);

        if (brand!=null && type!=null) {
            Product product = new Product();
            product.setBrandName(brand);
            product.setId(id);
            product.setModel(model);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setProductType(type);

            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Long id) {
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
    ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        if (productRepository.findById(id).orElse(null)!=null) {
            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        else
            return ResponseEntity.notFound().build();
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
            product.setBrandName(brand);
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
            product.setProductType(type);
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("products/{id}/productToProperties/{prodToProp_id}")
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
    }

    @GetMapping("brandNames")
    ResponseEntity<List> getBrands(){
        return new ResponseEntity<>(brandRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("types")
    ResponseEntity<List> getTypes(){
        return new ResponseEntity<>(typeRepository.findAll(),HttpStatus.OK);
    }
}
