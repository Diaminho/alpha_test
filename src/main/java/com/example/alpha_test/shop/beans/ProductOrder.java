package com.example.alpha_test.shop.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ProductOrder {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private Long productType_id;

    private Long brandName_id;

    private Long quantity;
}
