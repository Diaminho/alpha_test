package com.example.alpha_test.controller;

import com.example.alpha_test.dto.BrandNameDTO;
import com.example.alpha_test.service.impl.BrandNameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandNameController {

    @Autowired
    private BrandNameServiceImpl brandNameServiceImpl;

    //default constructor
    BrandNameController() { }

    /**
     * getting all brands
     * @return ResponseEntity with List of all BrandNames
     */
    @GetMapping("/brandNames")
    public ResponseEntity<List<BrandNameDTO>> findAll(){
        List<BrandNameDTO> brandNameDTOList=brandNameServiceImpl.findAll();
        if (brandNameDTOList.size()>0){
            return new ResponseEntity<>(brandNameDTOList, HttpStatus.OK);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
