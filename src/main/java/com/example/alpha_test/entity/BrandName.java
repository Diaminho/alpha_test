package com.example.alpha_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="brand")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BrandName {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "brandName", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnore
    private Set<Product> products=new HashSet<>();

    //default constructor
    public BrandName(){}

    public BrandName(Long id, String name) {
        this.name = name;
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandName brandName = (BrandName) o;
        return Objects.equals(id, brandName.id) &&
                name.compareTo(brandName.name)==0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, products);
    }
}
