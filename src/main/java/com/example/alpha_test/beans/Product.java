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
    private Type productType;

    @ManyToOne(targetEntity = BrandName.class)
    @JoinColumn(name="brand_id")
    //@JsonBackReference
    @JsonIgnoreProperties("products")
    private BrandName brandName;

    @Column(name="quantity")
    private Long quantity;

    @Column(name="price")
    private double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
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

    public Type getProductType() {
        return productType;
    }

    public void setProductType(Type productType) {
        this.productType = productType;
    }

    public BrandName getBrandName() {
        return brandName;
    }


    public void setBrandName(BrandName brandName) {
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

    public Set<ProductToProperty> getProductToProperties() {
        return productToProperties;
    }


    public void setProductToProperties(Set<ProductToProperty> productToProperties) {
        this.productToProperties = productToProperties;
    }

    public Product(Long id, String model, Type productType, BrandName brandName, Long quantity, double price) {
        this.model = model;
        this.productType = productType;
        this.brandName = brandName;
        this.quantity = quantity;
        this.price = price;
        this.id=id;
    }


    /*public Set<ProductToProperty> getProductToProperties() {
        return productToProperties.;
    }*/

    public Product() {}


}
