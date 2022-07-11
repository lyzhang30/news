package com.DY.utils;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    /**
     * 当前页码
     */
    private int currentPage;
    /**
     * 每页显示的新闻条数
     */
    private int pageSize;
    /**
     * 新闻数量
     */
    private int count;

    public PageBean() {

    }

    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 当前页的新闻集合数
     */
    private List<T> list;
}
