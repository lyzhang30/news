package com.DY.mapper;

import com.DY.entity.Category;

import java.util.List;

public interface CategoryMapper {
    /**
     * 查询所有的新闻类别
     */
    public List<Category> querryCategory();
    /**
     * 根据新闻类别查询新闻
     */
    public Category querryCategoryById(Integer categoryId);

}
