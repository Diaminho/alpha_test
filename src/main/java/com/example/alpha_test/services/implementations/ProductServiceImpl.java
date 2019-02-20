package com.example.alpha_test.services.implementations;

import com.example.alpha_test.entities.*;
import com.example.alpha_test.repositories.*;
import com.example.alpha_test.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BrandNameRepository brandNameRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    ProductToPropertyRepository productToPropertyRepository;

    @Autowired
    PropertyRepository propertyRepository;

    //default constructor
    public ProductServiceImpl() { }

    //getting all products from  productRepository
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    //changing or adding product
    public ResponseEntity<Product> putProduct(Long id,
                                         String model,
                                         Long brandId,
                                         Long typeId,
                                         Long quantity,
                                         Double price)
    {
        //checks if null parameters are presented in input data
        if (id==null || model==null || brandId==null || quantity==null || price==null){
            return new ResponseEntity<>((Product) null, HttpStatus.NOT_FOUND);
        }

        //find brand and type by id
        BrandName brand=brandNameRepository.getById(brandId);
        Type type=typeRepository.getById(typeId);

        //check if data were found
        if (brand!=null && type!=null) {
            Product product = new Product(id, model, type, brand, quantity, price);
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>((Product)null, HttpStatus.NOT_FOUND);
        }
    }

    //finding product by id
    public ResponseEntity<Product> getProductById( Long id) {
        Product product=productRepository.getById(id);
        if (product!=null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>((Product)null, HttpStatus.NOT_FOUND);
        }
    }

    //deleting product by id
    public ResponseEntity<Void> deleteProductById(Long id) {
        if (productRepository.getById(id)!=null) {
            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        else
            return ResponseEntity.notFound().build();
    }

    //editing price of product with id=id
    public ResponseEntity<Product> editPrice(Long id, Double newPrice){
        Product product=productRepository.getById(id);
        if (product!=null && newPrice!=null) {
            product.setPrice(newPrice);
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>((Product)null,HttpStatus.NOT_FOUND);
        }
    }

    //editing quantity of product with id=id
    public ResponseEntity<Product> editQuantity(Long id, Long newQuantity){
        Product product=productRepository.findById(id).orElse(null);
        if (product!=null && newQuantity!=null) {
            product.setQuantity(newQuantity);
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>((Product)null,HttpStatus.NOT_FOUND);
        }
    }

    //editing brand of product with id=id
    public ResponseEntity<Product> editBrandNameId(Long id, Long newBrandNameId){
        Product product=productRepository.getById(id);
        BrandName brand=brandNameRepository.getById(id);
        if (product!=null && brand!=null && newBrandNameId!=null) {
            product.setBrandName(brand);
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>((Product)null,HttpStatus.NOT_FOUND);
        }
    }

    //editing type of product with id=id
    public ResponseEntity<Product> editTypeId(Long id, Long newTypeId){
        Product product=productRepository.getById(id);
        Type type=typeRepository.getById(id);
        if (product!=null && type!=null && newTypeId!=null) {
            product.setProductType(type);
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>((Product)null,HttpStatus.NOT_FOUND);
        }
    }

    //editing property value with id=id
    public ResponseEntity<Product> editPropertyIdAndValue(Long id, Long productToPropertyId, Long propertyId, String newValue){
        if (id==null || newValue==null || propertyId==null){
            return new ResponseEntity<>((Product)null,HttpStatus.NOT_FOUND);
        }
        Product product=productRepository.getById(id);
        Property property=propertyRepository.getById(propertyId);
        ProductToProperty productToProperty=productToPropertyRepository.getById(productToPropertyId);
        if (productToProperty!=null && property!=null && product!=null) {
            productToProperty.setPropertyValue(newValue);
            productToProperty.setProperty(property);
            productToPropertyRepository.save(productToProperty);
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>((Product)null,HttpStatus.NOT_FOUND);
        }
    }
}
