package com.example.alpha_test.controllers;

import com.example.alpha_test.entities.*;
import com.example.alpha_test.controllers.ProductController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.Charset;
import java.util.Optional;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTests {

    /*@Autowired
    private MockMvc mockMvc;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));


    //REPOS
    @MockBean
    private BrandNameRepository brandNameRepository;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ProductToPropertyRepository productToPropertyRepository;

    @MockBean
    private PropertyRepository propertyRepository;

    @MockBean
    private TypeRepository typeRepository;

    //entities
    Product product=new Product();
    Type type=new Type();
    ProductToProperty productToProperty=new ProductToProperty();
    Property property=new Property();
    BrandName brand=new BrandName();


    @Test
    public void getProductById() throws Exception {
        type.setName("type1");
        type.setId(1L);

        brand.setId(1L);
        brand.setName("brand1");

        product.setId(1L);
        product.setQuantity(20L);
        product.setPrice(25.0);
        product.setProductType(type);
        product.setModel("TEST MODEL");
        product.setBrandName(brand);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        mockMvc.perform(get("/products/1").contentType(contentType))
                .andExpect(status().isOk()).
                andExpect(content().json("{\"id\":1,\"model\":\"TEST MODEL\",\"productType\":{\"id\":1,\"name\":\"type1\"},\"brandName\":{\"id\":1,\"name\":\"brand1\"},\"quantity\":20,\"price\":25.0,\"productToProperties\":[]}"));

        System.out.println("TEST getProductById PASSED");
    }

    @Test
    public void getProductByWrongId() throws Exception {
        type.setName("type1");
        type.setId(1L);

        brand.setId(1L);
        brand.setName("brand1");

        product.setId(1L);
        product.setQuantity(20L);
        product.setPrice(25.0);
        product.setProductType(type);
        product.setModel("TEST MODEL");
        product.setBrandName(brand);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        mockMvc.perform(get("/products/2").contentType(contentType))
                .andExpect(status().isNotFound());

        System.out.println("TEST getProductByWrongId PASSED");
    }

    @Test
    public void addProductWithCorrectId() throws Exception {
        type.setName("type1");
        type.setId(1L);

        brand.setId(1L);
        brand.setName("brand1");

        when(brandNameRepository.findById(1L)).thenReturn(Optional.of(brand));
        when(typeRepository.findById(1L)).thenReturn(Optional.of(type));
        MvcResult result= mockMvc.perform(put("/products?id=1&model=NEW&brandId=1&typeId=1&quantity=20&price=25.0").contentType(contentType)
                .content("{\"id\":1,\"model\":\"NEW\",\"productType\":{\"id\":1,\"name\":\"type1\"},\"brandName\":{\"id\":1,\"name\":\"brand1\"},\"quantity\":20,\"price\":25.0,\"productToProperties\":[]}"))
                .andReturn();

        assertEquals("Wrong HTTP Status",HttpStatus.OK.value(),result.getResponse().getStatus());

        verify(productRepository).save(any(Product.class));

        System.out.println("TEST addProduct PASSED");
    }

    @Test
    public void addProductWithWrongBrandId() throws Exception {
        type.setName("type1");
        type.setId(1L);

        brand.setId(1L);
        brand.setName("brand1");

        when(brandNameRepository.findById(1L)).thenReturn(Optional.of(brand));
        when(typeRepository.findById(1L)).thenReturn(Optional.of(type));
        MvcResult result= mockMvc.perform(put("/products?id=1&model=NEW&brandId=2&typeId=1&quantity=20&price=25.0").contentType(contentType)
                .content("{\"id\":1,\"model\":\"NEW\",\"productType\":{\"id\":1,\"name\":\"type1\"},\"brandName\":{\"id\":2,\"name\":\"brand1\"},\"quantity\":20,\"price\":25.0,\"productToProperties\":[]}"))
                .andReturn();

        assertEquals("Wrong HTTP Status",HttpStatus.NOT_FOUND.value(),result.getResponse().getStatus());

        System.out.println("TEST addProductWithWrongBrandId PASSED");
    }

    @Test
    public void deleteProductWithWrongId() throws Exception {
        type.setName("type1");
        type.setId(1L);

        brand.setId(1L);
        brand.setName("brand1");

        product.setId(1L);
        product.setQuantity(20L);
        product.setPrice(25.0);
        product.setProductType(type);
        product.setModel("TEST MODEL");
        product.setBrandName(brand);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        when(brandNameRepository.findById(1L)).thenReturn(Optional.of(brand));
        when(typeRepository.findById(1L)).thenReturn(Optional.of(type));
        MvcResult result= mockMvc.perform(delete("/products/2")).andReturn();

        assertEquals("Wrong HTTP Status",HttpStatus.NOT_FOUND.value(),result.getResponse().getStatus());

        System.out.println("TEST deleteProductWithWrongId PASSED");

    }
    */


    /*@Autowired
    private MockMvc mockMvc;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));




    @Test
    public void deleteProductWithExistingId() throws Exception {
        type.setName("type1");
        type.setId(1L);

        brand.setId(1L);
        brand.setName("brand1");

        product.setId(1L);
        product.setQuantity(20L);
        product.setPrice(25.0);
        product.setProductType(type);
        product.setModel("TEST MODEL");
        product.setBrandName(brand);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        when(brandNameRepository.findById(1L)).thenReturn(Optional.of(brand));
        when(typeRepository.findById(1L)).thenReturn(Optional.of(type));
        MvcResult result= mockMvc.perform(delete("/products/1")).andReturn();

        assertEquals("Wrong HTTP Status",HttpStatus.OK.value(),result.getResponse().getStatus());

        verify(productRepository).deleteById(1L);

        System.out.println("TEST deleteProduct PASSED");

    }


    */

}

