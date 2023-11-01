package com.pbp.ecommercecomputer.service.impl;

import com.pbp.ecommercecomputer.dto.ProductDto;
import com.pbp.ecommercecomputer.entity.Category;
import com.pbp.ecommercecomputer.entity.Product;
import com.pbp.ecommercecomputer.mapper.ProductMapper;
import com.pbp.ecommercecomputer.repository.CategoryRepository;
import com.pbp.ecommercecomputer.repository.ProductRepository;
import com.pbp.ecommercecomputer.request.ProductRequest;
import com.pbp.ecommercecomputer.service.ProductService;
import com.pbp.ecommercecomputer.util.MyUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ProductDto> findAll() {
        List<Product> product = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<ProductDto>();

        product.forEach(p ->
                productDtos.add(ProductMapper.toDto(p))
        );

        return productDtos;
    }

    @Override
    @Transactional
    public void save(ProductRequest productRequest) {
        try {
            Product product = new Product();
            Category category = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow();

            BeanUtils.copyProperties(productRequest, product);
            product.setId(MyUtils.generateUUID());
            product.setCategory(category);

            productRepository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductDto> findByCategoryName(String name) {
        try {
            List<Product> products = productRepository.findByCategory_Name(name);
            List<ProductDto> productDtos = new ArrayList<>();

            products.forEach(p ->
                    productDtos.add(ProductMapper.toDto(p))
            );

            return productDtos;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
