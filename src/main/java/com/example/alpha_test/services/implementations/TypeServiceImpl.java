package com.example.alpha_test.services.implementations;

import com.example.alpha_test.converters.EntityToDTOConverter;
import com.example.alpha_test.dto.TypeDTO;
import com.example.alpha_test.entities.Type;
import com.example.alpha_test.repositories.TypeRepository;
import com.example.alpha_test.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeRepository typeRepository;

    @Autowired
    EntityToDTOConverter entityToDTOConverter;

    public ResponseEntity<List<TypeDTO>> findAll(){
        List<Type> typeList=typeRepository.findAll();
        List<TypeDTO> typeDTOList=new ArrayList<>();
        for (Object type:typeList){
            typeDTOList.add(entityToDTOConverter.typeToDTO((Type) type));
        }
        return new ResponseEntity<>(typeDTOList, HttpStatus.OK);
    }

}
