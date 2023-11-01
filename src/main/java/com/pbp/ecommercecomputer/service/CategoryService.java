package com.pbp.ecommercecomputer.service;

import com.pbp.ecommercecomputer.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    void save(Category category);
}
