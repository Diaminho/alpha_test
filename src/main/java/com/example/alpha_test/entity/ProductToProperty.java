package com.example.alpha_test.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="product_property")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductToProperty {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @ManyToOne(targetEntity = Product.class, fetch=FetchType.LAZY)
    @JoinColumn(name="product_id")
    @JsonBackReference
    private Product product;

    @ManyToOne(targetEntity = Property.class, fetch=FetchType.LAZY)
    @JoinColumn(name="property_id")
    @JsonIgnoreProperties({"productToProperties","type_id"})
    private Property property;

    @Column(name="value")
    private String propertyValue;

    //default constructor
    public ProductToProperty() { }

    public ProductToProperty(Product product, Property property, String propertyValue) {
        this.product = product;
        this.property = property;
        this.propertyValue = propertyValue;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductToProperty that = (ProductToProperty) o;
        return Objects.equals(id, that.id) &&
                product.equals(that.product) &&
                property.equals(that.property) &&
                propertyValue.compareTo(that.propertyValue)==0;
    }
}
