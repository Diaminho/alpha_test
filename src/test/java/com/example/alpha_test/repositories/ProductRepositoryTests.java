package com.example.alpha_test.repositories;

import com.example.alpha_test.entity.BrandName;
import com.example.alpha_test.entity.Product;
import com.example.alpha_test.entity.Type;
import com.example.alpha_test.repository.BrandNameRepository;
import com.example.alpha_test.repository.ProductRepository;
import com.example.alpha_test.repository.TypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ProductRepositoryTests {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    BrandNameRepository brandNameRepository;


    @Test
    public void shouldFindProduct(){
        Type type=typeRepository.getById(1L);
        BrandName brandName=brandNameRepository.getById(1L);
        Product product=new Product(22L,"Model",type,brandName,25L,200.0);
        productRepository.save(product);

        Product productRepo=productRepository.getById(22L);
        assertThat(productRepo).isEqualTo(product);
    }

    @Test
    public void shouldDeleteProduct(){
        Type type=typeRepository.getById(1L);
        BrandName brandName=brandNameRepository.getById(1L);
        Product product=new Product(22L,"Model",type,brandName,25L,200.0);
        productRepository.save(product);

        productRepository.deleteById(22L);
        assertThat(productRepository.getById(22L)).isEqualTo(null);
    }

    @Test
    public void shouldReturnListOfProducts(){
        productRepository.deleteAll();

        Type type=typeRepository.getById(1L);
        BrandName brandName=brandNameRepository.getById(1L);
        Product product=new Product(1L,"Model",type,brandName,25L,200.0);
        productRepository.save(product);

        type=typeRepository.getById(2L);
        brandName=brandNameRepository.getById(2L);
        Product product2=new Product(2L,"New Model",type,brandName,50L,200.0);
        productRepository.save(product2);

        List<Product> productList=productRepository.findAll();
        assertThat(productList.size()).isEqualTo(2);
        assertThat(productList.get(0)).isEqualTo(product);
        assertThat(productList.get(1)).isEqualTo(product2);
    }

    @Test
    public void shouldDeleteAllProducts(){

        Type type=typeRepository.getById(1L);
        BrandName brandName=brandNameRepository.getById(1L);
        Product product=new Product(1L,"Model",type,brandName,25L,200.0);
        productRepository.save(product);

        productRepository.deleteAll();

        List<Product> productList=productRepository.findAll();
        assertThat(productList.size()).isEqualTo(0);
    }
}
