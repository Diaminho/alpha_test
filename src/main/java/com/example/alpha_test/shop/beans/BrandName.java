package com.example.alpha_test.shop.beans;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "brandNameId", cascade = CascadeType.ALL)
    private Set<Product> products;

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

    public BrandName(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    public BrandName(){}
}
