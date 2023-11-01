package com.pbp.ecommercecomputer.mapper;

import com.pbp.ecommercecomputer.dto.ProductDto;
import com.pbp.ecommercecomputer.entity.Product;
import org.springframework.beans.BeanUtils;

public class ProductMapper {

    public static ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();

        BeanUtils.copyProperties(product, productDto);
        productDto.setCategoryName(product.getCategory().getName());

        return productDto;
    }
}
