package com.example.alpha_test.shop.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Property {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
