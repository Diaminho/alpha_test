package com.example.alpha_test.entities;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
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

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ProductToProperty> productToProperties=new HashSet<>();

    //default constructor
    public Property() { }

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

    public void setProductToProperties(Set<ProductToProperty> productToProperties) {
        this.productToProperties = productToProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(id, property.id) &&
                Objects.equals(type_id, property.type_id) &&
                Objects.equals(name, property.name) &&
                Objects.equals(productToProperties, property.productToProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type_id, name, productToProperties);
    }
}


