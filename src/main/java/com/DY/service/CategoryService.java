package com.DY.service;

import com.DY.entity.Category;

import java.util.List;

public interface CategoryService {

    /***
     * 查询所有新闻类别
     * @return
     */
    public List<Category> querryCategory();
    /**
     * 根据新闻类别Id查询新闻
     */
    public Category querryCategoryById(Integer categoryId);

}
