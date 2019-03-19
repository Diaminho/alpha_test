package com.example.alpha_test.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="property")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Property {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @ManyToOne(targetEntity = Type.class, fetch=FetchType.LAZY)
    @JoinColumn(name="type_id")
    @JsonIgnoreProperties("products")
    private Type type;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnore
    private Set<ProductToProperty> productToProperties=new HashSet<>();

    //default constructor
    public Property() { }

    public Property(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
                Objects.equals(type, property.type) &&
                name.compareTo(property.name)==0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, productToProperties);
    }
}