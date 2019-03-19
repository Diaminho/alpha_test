package com.example.alpha_test.controller;

import com.example.alpha_test.dto.TypeDTO;
import com.example.alpha_test.service.impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController {

    @Autowired
    private TypeServiceImpl typeServiceImpl;

    //default constructor
    TypeController() { }

    /**
     * getting all types
     * @return ResponseEntity with List of all Type
     */
    @GetMapping("/types")
    public ResponseEntity<List<TypeDTO>> findAll(){
        List<TypeDTO> typeDTOList=typeServiceImpl.findAll();
        if (typeDTOList.size()>0){
            return new ResponseEntity<>(typeDTOList, HttpStatus.OK);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
