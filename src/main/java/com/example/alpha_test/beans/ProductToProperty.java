package com.example.alpha_test.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="product_property")
public class ProductToProperty {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name="product_id")
    @JsonBackReference
    private Product product;

    @ManyToOne(targetEntity = Property.class)
    @JoinColumn(name="property_id")
    @JsonIgnoreProperties({"productToProperties","type_id"})
    private Property property;
    @Column(name="value")
    private String propertyValue;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
