package com.example.alpha_test.services.implementations;

import com.example.alpha_test.entities.BrandName;
import com.example.alpha_test.repositories.BrandNameRepository;
import com.example.alpha_test.services.BrandNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandNameServiceImpl implements BrandNameService {
    @Autowired
    BrandNameRepository brandNameRepository;

    public ResponseEntity<List<BrandName>> findAll(){
        return new ResponseEntity<>(brandNameRepository.findAll(), HttpStatus.OK);
    }

}
