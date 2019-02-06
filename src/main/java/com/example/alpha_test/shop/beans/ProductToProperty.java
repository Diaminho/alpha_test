package com.example.alpha_test.shop.beans;

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
    private Product productId;
    @ManyToOne(targetEntity = Property.class)
    @JoinColumn(name="property_id")
    private Property propertyId;
    @Column(name="value")
    private String propertyValue;

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Property getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Property propertyId) {
        this.propertyId = propertyId;
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
