package com.example.alpha_test.dto;

import java.util.HashSet;
import java.util.Set;

public class ProductDTO {
    private Long id;
    private String model;
    private TypeDTO productType;
    private BrandNameDTO brandName;
    private Long quantity;
    private double price;
    private Set<ProductToPropertyDTO> productToProperties=new HashSet<>();

    public ProductDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public TypeDTO getProductType() {
        return productType;
    }

    public void setProductType(TypeDTO productType) {
        this.productType = productType;
    }

    public BrandNameDTO getBrandName() {
        return brandName;
    }

    public void setBrandName(BrandNameDTO brandName) {
        this.brandName = brandName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<ProductToPropertyDTO> getProductToProperties() {
        return productToProperties;
    }

    public void setProductToProperties(Set<ProductToPropertyDTO> productToProperties) {
        this.productToProperties = productToProperties;
    }
}
