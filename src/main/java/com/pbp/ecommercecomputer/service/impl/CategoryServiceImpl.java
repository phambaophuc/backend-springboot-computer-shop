package com.pbp.ecommercecomputer.service.impl;

import com.pbp.ecommercecomputer.entity.Category;
import com.pbp.ecommercecomputer.repository.CategoryRepository;
import com.pbp.ecommercecomputer.service.CategoryService;
import com.pbp.ecommercecomputer.util.MyUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        try {
            category.setId(MyUtils.generateUUID());
            categoryRepository.save(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
