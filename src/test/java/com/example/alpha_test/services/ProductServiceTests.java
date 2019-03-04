package com.example.alpha_test.services;

import com.example.alpha_test.entities.*;
import com.example.alpha_test.repositories.*;
import com.example.alpha_test.services.implementations.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringRunner.class)
public class ProductServiceTests {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private TypeRepository typeRepository;
    @Mock
    private BrandNameRepository brandNameRepository;
    @Mock
    private PropertyRepository propertyRepository;
    @Mock
    private ProductToPropertyRepository productToPropertyRepository;

    @InjectMocks
    private ProductServiceImpl productService = new ProductServiceImpl();

    //TEST DATA

    Type type;
    BrandName brandName;
    Product product;
    Property property;
    ProductToProperty productToProperty;

    @Before
    public void setUp(){
        type=new Type(1L,"Type");
        brandName=new BrandName(1L,"Brand");
        product=new Product(1L,"Model",type,brandName,25L,200.0);
        property = new Property(type, "Property");
        property.setId(1L);
        productToProperty = new ProductToProperty(product, property, "100");
        productToProperty.setId(1L);
    }

    //PRODUCT TESTS
    @Test
    public void shouldGetProductById(){
        when(productRepository.getById(1L)).thenReturn(product);
        productService.getProductById(1L);
        verify(productRepository).getById(1L);
    }

    //wrong product id
    @Test
    public void shouldNotGetProductById(){
        when(productRepository.getById(1L)).thenReturn(product);
        productService.getProductById(2L);
        assertThat((productRepository).getById(2L)).isEqualTo(null);
    }

    @Test
    public void shouldPutProduct(){
        when(productRepository.save(product)).thenReturn(product);
        when(typeRepository.getById(1L)).thenReturn(type);
        when(brandNameRepository.getById(1L)).thenReturn(brandName);
        productService.putProduct(product.getId(),product.getModel(),product.getProductType().getId(),product.getBrandName().getId(),product.getQuantity(),product.getPrice());
        verify(productRepository).save(product);
    }

    //wrong type id
    @Test
    public void shouldNotPutProductWithWrongTypeId(){
        when(productRepository.save(product)).thenReturn(product);
        when(typeRepository.getById(1L)).thenReturn(type);
        when(brandNameRepository.getById(1L)).thenReturn(brandName);
        productService.putProduct(1L,product.getModel(), 1L,2L, product.getQuantity(),product.getPrice());
        verify(productRepository, times(0)).save(product);
    }

    //wrong BrandName id
    @Test
    public void shouldNotPutProductWithWrongBrandNameId(){
        when(productRepository.save(product)).thenReturn(product);
        when(typeRepository.getById(1L)).thenReturn(type);
        when(brandNameRepository.getById(1L)).thenReturn(brandName);
        productService.putProduct(1L,product.getModel(), 2L,1L, product.getQuantity(),product.getPrice());
        verify(productRepository, times(0)).save(product);
    }

    @Test
    public void shouldDeleteProductById(){
        when(productRepository.getById(1L)).thenReturn(product);
        productService.deleteProductById(1L);
        verify(productRepository).deleteById(1L);
    }

    //wrong product id
    @Test
    public void shouldNotDeleteProductByWrongId(){
        when(productRepository.getById(1L)).thenReturn(product);
        productService.deleteProductById(2L);
        verify(productRepository, times(0)).deleteById(1L);
    }

    //PRICE TESTS
    @Test
    public void shouldEditPrice(){
        when(productRepository.getById(1L)).thenReturn(product);
        productService.editPrice(1L,55.5D);
        assertThat(productRepository.getById(1L).getPrice()).isEqualTo(55.5D);
        verify(productRepository).save(product);
    }

    //price==null
    @Test
    public void shouldNotEditPriceWithNullValue(){
        when(productRepository.getById(1L)).thenReturn(product);
        productService.editPrice(1L,null);
        verify(productRepository, times(0)).save(product);
    }


    //QUANTITY TESTS
    @Test
    public void shouldEditQuantity(){
        when(productRepository.getById(1L)).thenReturn(product);
        productService.editQuantity(1L, 5L);
        assertThat(productRepository.getById(1L).getQuantity()).isEqualTo(5L);
        verify(productRepository).save(product);
    }

    //quantity==null
    @Test
    public void shouldNotEditQuantityWithNullValue(){
        when(productRepository.getById(1L)).thenReturn(product);
        productService.editQuantity(1L, null);
        verify(productRepository, times(0)).save(product);
    }

    //BRANDNAME TESTS
    @Test
    public void shouldEditBrandNameId(){
        BrandName newBrand=new BrandName(2L,"Brand2");
        when(productRepository.getById(1L)).thenReturn(product);
        when(brandNameRepository.getById(2L)).thenReturn(newBrand);
        productService.editBrandNameId(1L,2L);
        assertThat(productRepository.getById(1L).getBrandName().getId()).isEqualTo(2L);
        verify(productRepository).save(product);
    }

    //wrong brandNameId
    @Test
    public void shouldNotEditBrandNameIdWithWrongId(){
        BrandName newBrand=new BrandName(2L,"Brand2");
        when(productRepository.getById(1L)).thenReturn(product);
        when(brandNameRepository.getById(2L)).thenReturn(newBrand);
        productService.editBrandNameId(1L,3L);
        verify(productRepository, times(0)).save(product);
    }

    //TYPE TESTS
    @Test
    public void shouldEditTypeId(){
        Type newType=new Type(2L,"Type2");
        when(productRepository.getById(1L)).thenReturn(product);
        when(typeRepository.getById(2L)).thenReturn(newType);
        productService.editTypeId(1L,2L);
        assertThat(productRepository.getById(1L).getProductType().getId()).isEqualTo(2L);
        verify(productRepository).save(product);
    }

    //wrong typeId
    @Test
    public void shouldNotEditTypeIdWithWrongId(){
        Type newType=new Type(2L,"Type2");
        when(productRepository.getById(1L)).thenReturn(product);
        when(typeRepository.getById(2L)).thenReturn(newType);
        productService.editTypeId(1L,3L);
        verify(productRepository, times(0)).save(product);
    }

    //PROPERTY TESTS
    @Test
    public void shouldEditPropertyIdAndValue() {
        when(productRepository.getById(1L)).thenReturn(product);
        when(propertyRepository.getById(1L)).thenReturn(property);
        when(productToPropertyRepository.getById(1L)).thenReturn(productToProperty);
        productService.editPropertyIdAndValue(1L, 1L, 1L, "200");
        assertThat(productToPropertyRepository.getById(1L).getPropertyValue()).isEqualTo("200");
        verify(productToPropertyRepository).save(productToProperty);
        verify(productRepository).save(product);
    }

    //wrong propertyId
    @Test
    public void shouldNotEditPropertyIdAndValueWithWrongPropertyId() {
        when(productRepository.getById(1L)).thenReturn(product);
        when(propertyRepository.getById(1L)).thenReturn(property);
        when(productToPropertyRepository.getById(1L)).thenReturn(productToProperty);
        productService.editPropertyIdAndValue(1L, 1L, 2L, "200");
        verify(productToPropertyRepository, times(0)).save(productToProperty);
        verify(productRepository, times(0)).save(product);
    }

    //wrong productToPropertyId
    @Test
    public void shouldNotEditPropertyIdAndValueWithWrongProductToPropertyId() {
        when(productRepository.getById(1L)).thenReturn(product);
        when(propertyRepository.getById(1L)).thenReturn(property);
        when(productToPropertyRepository.getById(1L)).thenReturn(productToProperty);
        productService.editPropertyIdAndValue(1L, 2L, 1L, "200");
        verify(productToPropertyRepository, times(0)).save(productToProperty);
        verify(productRepository, times(0)).save(product);
    }

    //propertyValue==null
    @Test
    public void shouldNotEditPropertyIdAndValueWithNullPropertyValue() {
        when(productRepository.getById(1L)).thenReturn(product);
        when(propertyRepository.getById(1L)).thenReturn(property);
        when(productToPropertyRepository.getById(1L)).thenReturn(productToProperty);
        productService.editPropertyIdAndValue(1L, 1L, 1L, null);
        verify(productToPropertyRepository, times(0)).save(productToProperty);
        verify(productRepository, times(0)).save(product);
    }
}