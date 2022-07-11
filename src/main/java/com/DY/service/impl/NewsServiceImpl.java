package com.DY.service.impl;


import com.DY.entity.News;
import com.DY.mapper.NewsMapper;
import com.DY.service.NewsService;
import com.DY.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public Integer querryNewsCount(String keywords, Integer newsListCategoryId) {
        return this.newsMapper.querryNewsCount(keywords, newsListCategoryId);
    }

    @Override
    public PageBean<News> querryNewsList(String keywords, Integer newsListCategoryId, Integer currentPage, Integer pageSize) {

        //获取当前类别的信息数量
        int  count = this.newsMapper.querryNewsCount(keywords, newsListCategoryId);
        //求总页数
        int totalPage = (int) Math.ceil(count*1.0/pageSize);
        if(currentPage ==0){
            currentPage =1;
        }
        List<News> newsList = newsMapper.querryNewsList(keywords, newsListCategoryId, pageSize*(currentPage - 1) , pageSize);
        PageBean<News> pb = new PageBean<>();
        pb.setCount(count);
        pb.setCurrentPage(currentPage);
        pb.setList(newsList);
        pb.setPageSize(pageSize);
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public News querryNewsById(Integer newsId) {
        return this.newsMapper.querryNewsById(newsId);
    }

    @Override
    public Integer addNews(News news) {
        return this.newsMapper.addNews(news);
    }

    @Override
    public Integer updateNews(News news) {
        return this.newsMapper.updateNews(news);
    }

    @Override
    public Integer updateNewsPublishStatus(News news) {
        return this.newsMapper.updateNewsPublishStatus(news);
    }

    @Override
    public Integer deleteNews(Integer newsId) {
        return this.newsMapper.deleteNews(newsId);
    }
}
