package com.example.alpha_test.controllers;

import com.example.alpha_test.entities.Type;
import com.example.alpha_test.services.implementations.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController {
    //Service
    @Autowired
    private TypeServiceImpl typeServiceImpl;

    //default constructor
    TypeController() { }

    //getting all types
    @GetMapping("/types")
    public ResponseEntity<List<Type>> findAll(){
        return typeServiceImpl.findAll();
    }
}
