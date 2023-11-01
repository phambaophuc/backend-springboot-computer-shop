package com.pbp.ecommercecomputer.rest;

import com.pbp.ecommercecomputer.dto.ProductDto;
import com.pbp.ecommercecomputer.request.ProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/api/products")
public interface ProductRest {

    @GetMapping
    ResponseEntity<List<ProductDto>> findAll();

    @GetMapping("/find-by-category/{name}")
    ResponseEntity<List<ProductDto>> findByCategoryName(@PathVariable("name") String name);

    @PostMapping("/create")
    ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest);
}
