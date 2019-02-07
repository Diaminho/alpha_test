package com.example.alpha_test.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @JsonIgnoreProperties("brandNameId")
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

    public BrandName(Long id, String name) {
        this.name = name;
        this.id=id;
    }

    public BrandName(){}

}
