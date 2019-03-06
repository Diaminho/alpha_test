package com.example.alpha_test.controller;

import com.example.alpha_test.entity.BrandName;
import com.example.alpha_test.service.impl.BrandNameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandNameController {
    //Service
    @Autowired
    private BrandNameServiceImpl brandNameServiceImpl;

    //default constructor
    BrandNameController() { }

    //getting all brands
    @GetMapping("/brandNames")
    public ResponseEntity<List<BrandName>> findAll(){
        return brandNameServiceImpl.findAll();
    }
}
