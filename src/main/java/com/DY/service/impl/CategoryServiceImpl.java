package com.DY.service.impl;

import com.DY.entity.Category;
import com.DY.mapper.CategoryMapper;
import com.DY.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> querryCategory() {
        return this.categoryMapper.querryCategory();
    }

    @Override
    public Category querryCategoryById(Integer categoryId) {
        return this.categoryMapper.querryCategoryById(categoryId);
    }
}
