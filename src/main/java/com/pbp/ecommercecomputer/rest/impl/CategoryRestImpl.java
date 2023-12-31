package com.pbp.ecommercecomputer.rest.impl;

import com.pbp.ecommercecomputer.entity.Category;
import com.pbp.ecommercecomputer.rest.CategoryRest;
import com.pbp.ecommercecomputer.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryRestImpl implements CategoryRest {

    private final CategoryService categoryService;

    @Override
    public ResponseEntity<List<Category>> findAll() {
        try {
            List<Category> categories = categoryService.findAll();

            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> createCategory(Category category) {
        try {
            categoryService.save(category);

            return ResponseEntity.ok("Created category successfully.");
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating category: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
