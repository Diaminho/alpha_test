package com.example.alpha_test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="brand")
public class BrandName {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "brandName", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Product> products=new HashSet<>();

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

    public BrandName(Long id, String name) {
        this.name = name;
        this.id=id;
    }

    public BrandName(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandName brandName = (BrandName) o;
        return Objects.equals(id, brandName.id) &&
                Objects.equals(name, brandName.name) &&
                Objects.equals(products, brandName.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, products);
    }
}
