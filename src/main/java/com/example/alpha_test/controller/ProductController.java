package com.example.alpha_test.controller;

import com.example.alpha_test.dto.ProductDTO;
import com.example.alpha_test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productServiceImpl;

    //default constructor
    ProductController() { }

    /**
     * getting all products
     * @return ResponseEntity with List all products
     */
    @GetMapping(value={"/products", "/"})
    ResponseEntity<List<ProductDTO>> getAllProducts() {
        List <ProductDTO> prodDTOList=productServiceImpl.findAll();
        if (prodDTOList!=null){
            return new ResponseEntity<>(prodDTOList, HttpStatus.OK);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * changing price of product with id={id}
     * @param id
     * @param model
     * @param brandId
     * @param typeId
     * @param quantity
     * @param price
     * @return ResponseEntity with changed ProductDTO as a content
     */
    @PutMapping("/products/{id}")
    ResponseEntity<ProductDTO> changeProduct(@PathVariable Long id,
                                         @RequestParam String model,
                                         @RequestParam Long brandId,
                                         @RequestParam Long typeId,
                                         @RequestParam Long quantity,
                                         @RequestParam Double price)
    {
        return buildResponseEntity(productServiceImpl.putProduct(id, model, brandId, typeId, quantity, price));
    }

    /**
     * adding product
     * @param id
     * @param model
     * @param brandId
     * @param typeId
     * @param quantity
     * @param price
     * @return ResponseEntity with added ProductDTO as a content
     */
    @PutMapping("/products")
    ResponseEntity<ProductDTO> addProduct(@RequestParam Long id,
                                          @RequestParam String model,
                                          @RequestParam Long brandId,
                                          @RequestParam Long typeId,
                                          @RequestParam Long quantity,
                                          @RequestParam Double price)
    {
        return buildResponseEntity(productServiceImpl.putProduct(id, model, brandId, typeId, quantity, price));
    }

    /**
     * getting product with id={id}
     * @param id
     * @return ResponseEntity with productDTO as a content
     */
    @GetMapping("/products/{id}")
    ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return buildResponseEntity(productServiceImpl.getProductById(id));
    }

    /**
     * deleting product by id
     * @param id
     * @return empty ResponseEntity
     */
    @DeleteMapping("/products/{id}")
    ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        Integer result=productServiceImpl.deleteProductById(id);
        if (result==0) {
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * changing price of product with id={id}
     * @param id
     * @param newPrice
     * @return ResponseEntity with ProductDTO as a content
     */
    @PutMapping("/products/{id}/price")
    ResponseEntity<ProductDTO> editPrice(@PathVariable Long id, @RequestParam Double newPrice){
        return buildResponseEntity(productServiceImpl.editPrice(id, newPrice));
    }

    /**
     * changing quantity of product with id={id}
     * @param id
     * @param newQuantity
     * @return ResponseEntity with changed Product that changed quantity
     */
    @PutMapping("/products/{id}/quantity")
    ResponseEntity<ProductDTO> editQuantity(@PathVariable Long id, @RequestParam Long newQuantity){
        return buildResponseEntity(productServiceImpl.editQuantity(id,newQuantity));
    }

    /**
     * changing brandName of product with id={id}
     * @param id
     * @param newBrandNameId
     * @return ResponseEntity with changed Product that changed brandName
     */
    @PutMapping("/products/{id}/brandName")
    ResponseEntity<ProductDTO> editBrandNameId(@PathVariable Long id, @RequestParam Long newBrandNameId){
        return buildResponseEntity(productServiceImpl.editBrandNameId(id, newBrandNameId));
    }

    /**
     * changing type of product with id={id}
     * @param id
     * @param newTypeId
     * @return ResponseEntity with changed Product that changed Type of product
     */
    @PutMapping("/products/{id}/type")
    ResponseEntity<ProductDTO> editTypeId(@PathVariable Long id, @RequestParam Long newTypeId){
        return buildResponseEntity(productServiceImpl.editTypeId(id, newTypeId));
    }

    /**
     * changing property value
     * @param id
     * @param productToPropertyId
     * @param propertyId
     * @param value
     * @return ResponseEntity with Product that changed property
     */
    @PutMapping("products/{id}/productToProperties/{productToPropertyId}/property/{propertyId}")
    ResponseEntity<ProductDTO> editPropertyIdAndValue(@PathVariable Long id, @PathVariable Long productToPropertyId, @PathVariable Long propertyId, @RequestParam String value){
        return buildResponseEntity(productServiceImpl.editPropertyIdAndValue(id,productToPropertyId, propertyId,value));
    }

    /**
     * Build ResponseEntity
     * @param productDTO
     * @return ResponseEntity with ProductDTO as a content or null if conditions are not fulfilled
     */
    private ResponseEntity<ProductDTO> buildResponseEntity(ProductDTO productDTO){
        if (productDTO!=null){
            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
