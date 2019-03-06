package com.example.alpha_test.service;

import com.example.alpha_test.dto.ProductDTO;
import com.example.alpha_test.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<List<ProductDTO>> findAll();
    ResponseEntity<Product> putProduct(Long id, String model, Long brandId, Long typeId, Long quantity, Double price);
    ResponseEntity<Product> getProductById( Long id);
    ResponseEntity<Void> deleteProductById(Long id);
    ResponseEntity<Product> editPrice(Long id, Double newPrice);
    ResponseEntity<Product> editQuantity(Long id, Long newQuantity);
    ResponseEntity<Product> editBrandNameId(Long id, Long newBrandNameId);
    ResponseEntity<Product> editTypeId(Long id, Long newTypeId);
    ResponseEntity<Product> editPropertyIdAndValue(Long id, Long productToPropertyId, Long propertyId, String newValue);
}
