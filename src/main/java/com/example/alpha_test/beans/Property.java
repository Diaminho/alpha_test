package com.example.alpha_test.beans;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="property")
public class Property {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="type_id")
    private Long type_id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "property", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<ProductToProperty> productToProperties=new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductToProperty> getProductToProperties() {
        return productToProperties;
    }

    @JsonProperty
    public void setProductToProperties(Set<ProductToProperty> productToProperties) {
        this.productToProperties = productToProperties;
    }
}


