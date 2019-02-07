package com.example.alpha_test.projections;

import com.example.alpha_test.beans.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ProductProjection", types = { Product.class })
public interface ProductProjection {
    Long getId();
    String getModel();
    //Long getTypeId();
    //Long getBrandId();
    Long getQuantity();
    double getPrice();
}
