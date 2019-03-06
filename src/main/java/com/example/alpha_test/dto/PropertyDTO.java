package com.example.alpha_test.dto;

import java.util.HashSet;
import java.util.Set;

public class PropertyDTO {
    private Long id;
    //private TypeDTO type;
    private String name;
    //private Set<ProductToPropertyDTO> productToProperties=new HashSet<>();

    public PropertyDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public TypeDTO getType() {
        return type;
    }*/

    /*public void setType(TypeDTO type) {
        this.type = type;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    public Set<ProductToPropertyDTO> getProductToProperties() {
        return productToProperties;
    }*/

    /*
    public void setProductToProperties(Set<ProductToPropertyDTO> productToProperties) {
        this.productToProperties = productToProperties;
    }*/
}
