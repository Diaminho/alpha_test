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
     * conerts BrandName to BrandNameDTO
     * @param brandName
     * @return BrandNameDTO
     */
    public BrandNameDTO brandNameToDTO(BrandName brandName){
        BrandNameDTO brandNameDTO=new BrandNameDTO(brandName.getId(),brandName.getName());
        //Set<Product> productsSet=brandName.getProducts();
        //Set<ProductDTO> productsDTOSet=productSetToDTO(productsSet);
        //brandNameDTO.setProducts(productsDTOSet);
        return brandNameDTO;
    }

    public TypeDTO typeToDTO(Type type){
        TypeDTO typeDTO=new TypeDTO(type.getId(), type.getName());
        //Set<Product> productSet=type.getProducts();
        //Set<ProductDTO> productDTOSet=productSetToDTO(productSet);
        //typeDTO.setProducts(productDTOSet);
        return typeDTO;
    }


    public PropertyDTO propertyToDTO(Property property){
        PropertyDTO propertyDTO=new PropertyDTO();
        propertyDTO.setId(property.getId());
        propertyDTO.setName(property.getName());

        //TypeDTO typeDTO=typeToDTO(property.getType());
        //propertyDTO.setType(typeDTO);

        //Set<ProductToProperty> productToPropertySet=property.getProductToProperties();
        //Set<ProductToPropertyDTO> productToPropertyDTOSet=productToPropertySetToDTO(productToPropertySet);
        //propertyDTO.setProductToProperties(productToPropertyDTOSet);
        return propertyDTO;
    }

    public ProductToPropertyDTO productToPropertyToDTO(ProductToProperty ptp){
        ProductToPropertyDTO ptpDTO=new ProductToPropertyDTO();
        ptpDTO.setId(ptp.getId());
        ptpDTO.setPropertyValue(ptp.getPropertyValue());

        //ProductDTO productDTO=productToDTO(ptp.getProduct());
        //ptpDTO.setProduct(productDTO);

        PropertyDTO propertyDTO=propertyToDTO(ptp.getProperty());
        ptpDTO.setProperty(propertyDTO);

        return ptpDTO;
    }


    private Set<ProductToPropertyDTO> productToPropertySetToDTO(Set<ProductToProperty> productToPropertiesSet){
        Set<ProductToPropertyDTO> productToPropertiesDTO=new HashSet<>();
        for (Object ptp:productToPropertiesSet){
            productToPropertiesDTO.add(productToPropertyToDTO((ProductToProperty) ptp));
        }
        return productToPropertiesDTO;
    }
}
