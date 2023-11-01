package com.pbp.ecommercecomputer.rest;

import com.pbp.ecommercecomputer.entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/api/categories")
public interface CategoryRest {

    @GetMapping
    ResponseEntity<List<Category>> findAll();

    @PostMapping("/create")
    ResponseEntity<String> createCategory(@RequestBody Category category);
}
