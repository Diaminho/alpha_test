package com.example.alpha_test.shop.beans;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="model")
    private String model;

    @ManyToOne(targetEntity = Type.class)
    @JoinColumn(name="type_id")
    private Type productTypeId;

    @ManyToOne(targetEntity = BrandName.class)
    @JoinColumn(name="brand_id")
    private BrandName brandNameId;

    @Column(name="quantity")
    private Long quantity;

    @Column(name="price")
    private double price;

    @OneToMany(mappedBy = "productId", cascade = CascadeType.ALL)
    private Set<ProductToProperty> productToProperties;

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

    public Type getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Type productTypeId) {
        this.productTypeId = productTypeId;
    }

    public BrandName getBrandNameId() {
        return brandNameId;
    }

    public void setBrandNameId(BrandName brandNameId) {
        this.brandNameId = brandNameId;
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

    public Set<ProductToProperty> getProductToProperties() {
        return productToProperties;
    }

    public void setProductToProperties(Set<ProductToProperty> productToProperties) {
        this.productToProperties = productToProperties;
    }
}
