package com.DY.service;

import com.DY.entity.Category;
import com.DY.entity.News;
import com.DY.utils.PageBean;

import java.util.List;

/**
*@author zhanglianyong
*@date 2022/7/3
 * 新闻业务接口类
*/
public interface NewsService {

    /**
     * 查询当前类别新闻的数量
     */
    public Integer querryNewsCount(String keywords,Integer newsListCategoryId);
    /**
     * 根据关键词查询所有的新闻
     */
    public PageBean<News> querryNewsList(String keywords, Integer newsListCategoryId, Integer startRows, Integer pageSize);
    /**
     * 根据新闻编号查询新闻信息
     */
    public News querryNewsById(Integer newsId);
    /**
     * 新加一条新闻
     */
    public Integer addNews(News news);
    /**
     * 更新新闻信息
     */
    public Integer updateNews(News news);
    /**
     * 更新新闻的发布状态
     */
    public Integer updateNewsPublishStatus(News news);
    /**
     * 根据新闻Id删除新闻
     */
    public Integer deleteNews(Integer newsId);
}
