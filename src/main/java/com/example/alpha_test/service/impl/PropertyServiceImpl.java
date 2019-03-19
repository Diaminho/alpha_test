package com.example.alpha_test.service.impl;

import com.example.alpha_test.converter.EntityToDTOConverter;
import com.example.alpha_test.dto.PropertyDTO;
import com.example.alpha_test.entity.Property;
import com.example.alpha_test.repository.PropertyRepository;
import com.example.alpha_test.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    EntityToDTOConverter entityToDTOConverter;

    public List<PropertyDTO> findAll(){
        List<Property> propertyList=propertyRepository.findAll();
        List propertyDTOList=new ArrayList<>(propertyList);
        propertyDTOList.replaceAll(s->entityToDTOConverter.propertyToDTO((Property)s));
        return propertyDTOList;
    }
}
