package com.DY.mapper;

import com.DY.entity.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    /**
     * 获取当前类别新闻的数量
     */
    public Integer querryNewsCount(@Param("keywords") String keywords,@Param("newsListCategoryId") Integer newsListCategoryId);
    /**
     * 根据关键词查询所有的新闻
     */
    public List<News> querryNewsList(@Param("keywords") String keywords,@Param("newsListCategoryId") Integer newsListCategoryId,@Param("startRows") Integer startRows,@Param("pageSize")Integer pageSize);
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
