package com.example.alpha_test.services;

import com.example.alpha_test.entities.Product;
import com.example.alpha_test.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<List<Product>> findAll();
    ResponseEntity<Product> putProduct(Long id, String model, Long brandId, Long typeId, Long quantity, Double price);
    ResponseEntity<Product> getProductById( Long id);
    ResponseEntity<Void> deleteProductById(Long id);
    ResponseEntity<Product> editPrice(Long id, Double newPrice);
    ResponseEntity<Product> editQuantity(Long id, Long newQuantity);
    ResponseEntity<Product> editBrandNameId(Long id, Long newBrandNameId);
    ResponseEntity<Product> editTypeId(Long id, Long newTypeId);
    ResponseEntity<Product> editPropertyIdAndValue(Long id, Long productToPropertyId, Long propertyId, String newValue);
}
