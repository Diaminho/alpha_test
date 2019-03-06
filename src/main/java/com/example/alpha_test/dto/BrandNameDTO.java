package com.example.alpha_test.dto;

import java.util.HashSet;
import java.util.Set;

public class BrandNameDTO {
    private Long id;
    private String name;
    //private Set<ProductDTO> products=new HashSet<>();

    public BrandNameDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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

    /*public Set<ProductDTO> getProducts() {
        return products;
    }*/

    /*public void setProducts(Set<ProductDTO> products) {
        this.products = products;
    }*/
}