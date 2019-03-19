package com.example.alpha_test.service.impl;

import com.example.alpha_test.converter.EntityToDTOConverter;
import com.example.alpha_test.dto.TypeDTO;
import com.example.alpha_test.entity.Type;
import com.example.alpha_test.repository.TypeRepository;
import com.example.alpha_test.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeRepository typeRepository;

    @Autowired
    EntityToDTOConverter entityToDTOConverter;

    public List<TypeDTO> findAll(){
        List<Type> typeList=typeRepository.findAll();
        List typeDTOList=new ArrayList(typeList);
        typeDTOList.replaceAll(s-> entityToDTOConverter.typeToDTO((Type)s));
        return typeDTOList;
    }

}
