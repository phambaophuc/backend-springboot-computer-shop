package com.pbp.ecommercecomputer.rest.impl;

import com.pbp.ecommercecomputer.dto.ProductDto;
import com.pbp.ecommercecomputer.request.ProductRequest;
import com.pbp.ecommercecomputer.rest.ProductRest;
import com.pbp.ecommercecomputer.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductRestImpl implements ProductRest {

    private final ProductService productService;

    @Override
    public ResponseEntity<List<ProductDto>> findAll() {
        try {
            List<ProductDto> productDtos = productService.findAll();

            return ResponseEntity.ok(productDtos);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<ProductDto>> findByCategoryName(String name) {
        try {
            List<ProductDto> productDtos = productService.findByCategoryName(name);

            return ResponseEntity.ok(productDtos);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<ProductDto>> findByProductName(String name) {
        try {
            List<ProductDto> productDtos = productService.findByProductName(name);

            return ResponseEntity.ok(productDtos);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> createProduct(ProductRequest productRequest) {
        try {
            productService.save(productRequest);

            return ResponseEntity.ok("Created product successfully.");
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong. " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
