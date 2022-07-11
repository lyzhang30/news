package com.DY.entity;

import lombok.Data;

import java.util.Date;

@Data
public class News {
    private Integer newsId;
    private String title;
    private String contentTitle;
    private String titlePicUrl;
    private String content;
    private String contentAbstract;
    private String keywords;
    private String author;
    private Date publishTime;
    private Integer clicks;
    private String publishStatus;
    private Integer categoryId;
    //为了方便新闻列表页显示，特意添加categoryName属性
    private String categoryName;
    private Integer userId;
}
