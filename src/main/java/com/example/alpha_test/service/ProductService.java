package com.example.alpha_test.service;

import com.example.alpha_test.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
    ProductDTO putProduct(Long id, String model, Long brandId, Long typeId, Long quantity, Double price);
    ProductDTO getProductById( Long id);
    Integer deleteProductById(Long id);
    ProductDTO editPrice(Long id, Double newPrice);
    ProductDTO editQuantity(Long id, Long newQuantity);
    ProductDTO editBrandNameId(Long id, Long newBrandNameId);
    ProductDTO editTypeId(Long id, Long newTypeId);
    ProductDTO editPropertyIdAndValue(Long id, Long productToPropertyId, Long propertyId, String newValue);
}
