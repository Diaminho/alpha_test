package com.example.alpha_test.services.implementations;

import com.example.alpha_test.entities.Type;
import com.example.alpha_test.repositories.TypeRepository;
import com.example.alpha_test.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeRepository typeRepository;

    public ResponseEntity<List<Type>> findAll(){
        return new ResponseEntity<>(typeRepository.findAll(), HttpStatus.OK);
    }

}
