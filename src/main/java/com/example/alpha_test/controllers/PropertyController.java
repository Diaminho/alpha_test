package com.example.alpha_test.controllers;

import com.example.alpha_test.entities.Property;
import com.example.alpha_test.services.implementations.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyController {
    //Service
    @Autowired
    PropertyServiceImpl propertyServiceImpl;

    //default constructor
    public PropertyController() { }

    //getting all properties
    @GetMapping("/properties")
    public ResponseEntity<List<Property>> findAll(){
        return propertyServiceImpl.findAll();
    }
}
