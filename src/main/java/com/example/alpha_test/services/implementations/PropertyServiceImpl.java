package com.example.alpha_test.services.implementations;

import com.example.alpha_test.entities.Property;
import com.example.alpha_test.repositories.PropertyRepository;
import com.example.alpha_test.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyRepository propertyRepository;

    @GetMapping("/properties")
    public ResponseEntity<List<Property>> findAll(){
        return new ResponseEntity<>(propertyRepository.findAll(), HttpStatus.OK);
    }
}
