package com.example.alpha_test.converter;

import com.example.alpha_test.dto.*;
import com.example.alpha_test.entity.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class EntityToDTOConverter {

    public EntityToDTOConverter() {
    }

    /**
     * Transforms Product Entity to Product DTO
     * @param product
     * @return ProductDTO
     */
    public ProductDTO productToDTO(Product product){
        ProductDTO productDTO=new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setModel(product.getModel());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setPrice(product.getPrice());

        BrandNameDTO brandNameDTO=brandNameToDTO(product.getBrandName());
        productDTO.setBrandName(brandNameDTO);

        TypeDTO typeDTO=typeToDTO(product.getProductType());
        productDTO.setProductType(typeDTO);

        Set<ProductToProperty> productToPropertiesSet=product.getProductToProperties();
        Set<ProductToPropertyDTO> productToPropertiesDTO=productToPropertySetToDTO(productToPropertiesSet);
        productDTO.setProductToProperties(productToPropertiesDTO);

        return productDTO;
    }

    /**
     * Transforms BrandName Entity to BrandNameDTO
     * @param brandName
     * @return BrandNameDTO
     */
    public BrandNameDTO brandNameToDTO(BrandName brandName){
        BrandNameDTO brandNameDTO=new BrandNameDTO(brandName.getId(),brandName.getName());
        return brandNameDTO;
    }

    /**
     * Transforms Type Entity to TypeDTO
     * @param type
     * @return TypeDTO
     */
    public TypeDTO typeToDTO(Type type){
        TypeDTO typeDTO=new TypeDTO(type.getId(), type.getName());
        return typeDTO;
    }

    /**
     * Transforms Property Entity to PropertyDTO
     * @param property
     * @return PropertyDTO
     */
    public PropertyDTO propertyToDTO(Property property){
        PropertyDTO propertyDTO=new PropertyDTO();
        propertyDTO.setId(property.getId());
        propertyDTO.setName(property.getName());
        return propertyDTO;
    }

    /**
     * Transforms ProductToProperty Entity to ProductToPropertyDTO
     * @param ptp
     * @return ProductToPropertyDTO
     */
    public ProductToPropertyDTO productToPropertyToDTO(ProductToProperty ptp){
        ProductToPropertyDTO ptpDTO=new ProductToPropertyDTO();
        ptpDTO.setId(ptp.getId());
        ptpDTO.setPropertyValue(ptp.getPropertyValue());

        PropertyDTO propertyDTO=propertyToDTO(ptp.getProperty());
        ptpDTO.setProperty(propertyDTO);

        return ptpDTO;
    }

    /**
     * Utility function to Transform the Set of ProductToProperty Entites to Set of ProductToPropertiesDTO
     * @param productToPropertiesSet
     * @return Set of ProductToPropertiesDTO
     */
    private Set<ProductToPropertyDTO> productToPropertySetToDTO(Set<ProductToProperty> productToPropertiesSet){
        Set<ProductToPropertyDTO> productToPropertiesDTO=new HashSet<>();
        for (Object ptp:productToPropertiesSet){
            productToPropertiesDTO.add(productToPropertyToDTO((ProductToProperty) ptp));
        }
        return productToPropertiesDTO;
    }
}
