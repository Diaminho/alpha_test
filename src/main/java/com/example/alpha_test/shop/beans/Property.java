package com.example.alpha_test.shop.beans;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "propertyId", cascade = CascadeType.ALL)
    private Set<ProductToProperty> productToProperties;
}


