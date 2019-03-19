package com.example.alpha_test.controller;

import com.example.alpha_test.dto.PropertyDTO;
import com.example.alpha_test.service.impl.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    PropertyServiceImpl propertyServiceImpl;

    //default constructor
    public PropertyController() { }

    /**
     * getting all properties
     * @return ResponseEntity with List of all Properties
     */
    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> findAll(){
        List<PropertyDTO> propertyDTOList=propertyServiceImpl.findAll();
        if (propertyDTOList.size()>0){
            return new ResponseEntity<>(propertyDTOList, HttpStatus.OK);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
