package com.example.alpha_test.beans;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="product")
public class Product {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="model")
    private String model;

    @ManyToOne(targetEntity = Type.class)
    @JoinColumn(name="type_id")
    //@JsonBackReference
    @JsonIgnoreProperties("products")
    private Type productTypeId;

    @ManyToOne(targetEntity = BrandName.class)
    @JoinColumn(name="brand_id")
    //@JsonBackReference
    @JsonIgnoreProperties("products")
    private BrandName brandNameId;

    @Column(name="quantity")
    private Long quantity;

    @Column(name="price")
    private double price;

    @OneToMany(mappedBy = "productId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<ProductToProperty> productToProperties=new HashSet<>();

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

    public Product(Long id, String model, Type productTypeId, BrandName brandNameId, Long quantity, double price) {
        this.model = model;
        this.productTypeId = productTypeId;
        this.brandNameId = brandNameId;
        this.quantity = quantity;
        this.price = price;
        this.id=id;
    }


    /*public Set<ProductToProperty> getProductToProperties() {
        return productToProperties.;
    }*/

    public Product() {}


}
