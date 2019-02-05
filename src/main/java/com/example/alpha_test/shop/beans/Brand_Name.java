package com.example.alpha_test.shop.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Brand_Name {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
