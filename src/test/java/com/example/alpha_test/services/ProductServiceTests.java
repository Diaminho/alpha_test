package com.example.alpha_test.services;

import com.example.alpha_test.entities.BrandName;
import com.example.alpha_test.entities.Product;
import com.example.alpha_test.entities.Type;
import com.example.alpha_test.repositories.BrandNameRepository;
import com.example.alpha_test.repositories.ProductRepository;
import com.example.alpha_test.repositories.TypeRepository;
import com.example.alpha_test.services.implementations.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
//@WebMvcTest(ProductServiceImpl.class)
public class ProductServiceTests {

    @Mock
    ProductRepository productRepository;
    @Mock
    TypeRepository typeRepository;
    @Mock
    BrandNameRepository brandNameRepository;


    @InjectMocks
    ProductServiceImpl productService = new ProductServiceImpl();

    @Test
    public void getProductById(){
        Type type=new Type(1L,"Type");
        BrandName brandName=new BrandName(1L,"Brand");
        Product product=new Product(22L,"Model",type,brandName,25L,200.0);

        when(productRepository.getById(22L)).thenReturn(product);

        productService.getProductById(22L);

        verify(productRepository).getById(22L);
    }

    @Test
    public void putProduct(){
        Type type=new Type(1L,"Type");
        BrandName brandName=new BrandName(1L,"Brand");
        Product product=new Product(22L,"Model",type,brandName,25L,200.0);

        when(productRepository.save(product)).thenReturn(product);
        when(typeRepository.getById(type.getId())).thenReturn(type);
        when(brandNameRepository.getById(brandName.getId())).thenReturn(brandName);

        productService.putProduct(product.getId(),product.getModel(),product.getProductType().getId(),product.getBrandName().getId(),product.getQuantity(),product.getPrice());

        verify(productRepository).save(product);
    }

}
