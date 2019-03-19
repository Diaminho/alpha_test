package com.example.alpha_test.service.impl;

import com.example.alpha_test.converter.EntityToDTOConverter;
import com.example.alpha_test.dto.ProductDTO;
import com.example.alpha_test.entity.*;
import com.example.alpha_test.repository.*;
import com.example.alpha_test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    EntityToDTOConverter entityToDTOConverter;

    //default constructor
    public ProductServiceImpl() { }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public BrandNameRepository getBrandNameRepository() {
        return brandNameRepository;
    }

    public void setBrandNameRepository(BrandNameRepository brandNameRepository) {
        this.brandNameRepository = brandNameRepository;
    }

    public TypeRepository getTypeRepository() {
        return typeRepository;
    }

    public void setTypeRepository(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public ProductToPropertyRepository getProductToPropertyRepository() {
        return productToPropertyRepository;
    }

    public void setProductToPropertyRepository(ProductToPropertyRepository productToPropertyRepository) {
        this.productToPropertyRepository = productToPropertyRepository;
    }

    public PropertyRepository getPropertyRepository() {
        return propertyRepository;
    }

    public void setPropertyRepository(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    //getting all products from  productRepository
    public List<ProductDTO> findAll(){
        List<Product> productList=productRepository.findAll();

        List<ProductDTO> productDTOList=new ArrayList<>();
        for(Object product: productList){
            productDTOList.add(entityToDTOConverter.productToDTO((Product) product));
        }
        return productDTOList;
    }

    //changing or adding product
    public ProductDTO putProduct(Long id,
                                         String model,
                                         Long brandId,
                                         Long typeId,
                                         Long quantity,
                                         Double price)
    {
        //checks if null parameters are presented in input data
        if (id==null || model==null || brandId==null || quantity==null || price==null){
            return null;
        }

        //find brand and type by id
        BrandName brand=brandNameRepository.getById(brandId);
        Type type=typeRepository.getById(typeId);

        //check if data were found
        if (brand!=null && type!=null) {
            Product product = new Product(id, model, type, brand, quantity, price);
            productRepository.save(product);
            ProductDTO productDTO=entityToDTOConverter.productToDTO(product);
            return productDTO;
        }
        else {
            return null;
        }
    }

    //finding product by id
    public ProductDTO getProductById(Long id) {
        Product product=productRepository.getById(id);
        if (product!=null ) {
            ProductDTO productDTO=entityToDTOConverter.productToDTO(product);
            return productDTO;
        }
        else
        {
            return null;
        }
    }

    //deleting product by id
    public Integer  deleteProductById(Long id) {
        if (productRepository.getById(id)!=null) {
            productRepository.deleteById(id);
            return 0;
        }
        else
            return 1;
    }

    //editing price of product with id=id
    public ProductDTO editPrice(Long id, Double newPrice){
        Product product=productRepository.getById(id);
        if (product!=null && newPrice!=null) {
            product.setPrice(newPrice);
            productRepository.save(product);
            ProductDTO productDTO=entityToDTOConverter.productToDTO(product);
            return productDTO;
        }
        else {
            return null;
        }
    }

    //editing quantity of product with id=id
    public ProductDTO editQuantity(Long id, Long newQuantity){
        Product product=productRepository.getById(id);
        if (product!=null && newQuantity!=null) {
            product.setQuantity(newQuantity);
            productRepository.save(product);
            ProductDTO productDTO=entityToDTOConverter.productToDTO(product);
            return productDTO;
        }
        else {
            return null;
        }
    }

    //editing brand of product with id=id
    public ProductDTO editBrandNameId(Long id, Long newBrandNameId){
        if (newBrandNameId==null) {
            return null;
        }
        Product product=productRepository.getById(id);
        BrandName brand=brandNameRepository.getById(newBrandNameId);
        if (product != null && brand != null) {
            product.setBrandName(brand);
            productRepository.save(product);
            ProductDTO productDTO=entityToDTOConverter.productToDTO(product);
            return productDTO;
        }
        else {
            return null;
        }
    }

    //editing type of product with id=id
    public ProductDTO editTypeId(Long id, Long newTypeId){
        if (newTypeId==null) {
            return null;
        }
        Product product=productRepository.getById(id);
        Type type=typeRepository.getById(newTypeId);
        if (product!=null && type!=null) {
            product.setProductType(type);
            productRepository.save(product);
            ProductDTO productDTO=entityToDTOConverter.productToDTO(product);
            return productDTO;
        }
        else {
            return null;
        }
    }

    //editing property value with id=id
    public ProductDTO editPropertyIdAndValue(Long id,
                                                          Long productToPropertyId,
                                                          Long propertyId,
                                                          String newValue){
        if (id==null || newValue==null || propertyId==null){
            return null;
        }
        Product product=productRepository.getById(id);
        Property property=propertyRepository.getById(propertyId);
        ProductToProperty productToProperty=productToPropertyRepository.getById(productToPropertyId);
        if (productToProperty!=null && property!=null && product!=null) {
            productToProperty.setPropertyValue(newValue);
            productToProperty.setProperty(property);
            productToPropertyRepository.save(productToProperty);
            productRepository.save(product);
            ProductDTO productDTO=entityToDTOConverter.productToDTO(product);
            return productDTO;
        }
        else {
            return null;
        }
    }
}
