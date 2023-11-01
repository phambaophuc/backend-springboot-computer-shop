package com.pbp.ecommercecomputer.service;

import com.pbp.ecommercecomputer.dto.ProductDto;
import com.pbp.ecommercecomputer.request.ProductRequest;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    void save(ProductRequest productRequest);

    List<ProductDto> findByCategoryName(String name);
}
