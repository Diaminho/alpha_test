package com.example.alpha_test.service.impl;

import com.example.alpha_test.converter.EntityToDTOConverter;
import com.example.alpha_test.dto.BrandNameDTO;
import com.example.alpha_test.entity.BrandName;
import com.example.alpha_test.repository.BrandNameRepository;
import com.example.alpha_test.service.BrandNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandNameServiceImpl implements BrandNameService {
    @Autowired
    BrandNameRepository brandNameRepository;

    @Autowired
    EntityToDTOConverter entityToDTOConverter;

    public List<BrandNameDTO> findAll(){
        List<BrandName> brandNameList=brandNameRepository.findAll();
        List brandNameDTOList=new ArrayList(brandNameList);
        brandNameDTOList.replaceAll(s-> entityToDTOConverter.brandNameToDTO((BrandName)s));
        return brandNameDTOList;
    }

}
