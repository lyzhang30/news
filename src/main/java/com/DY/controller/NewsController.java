package com.DY.controller;

import com.DY.entity.Category;
import com.DY.entity.News;
import com.DY.service.CategoryService;
import com.DY.service.NewsService;
import com.DY.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller

public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private CategoryService categoryService;
    //查询新闻分页
    @RequestMapping(value="/findCategoryList")
    public String findRoleList(Model model ){
        List<Category> categoryList = categoryService.querryCategory();
        model.addAttribute("categoryList",categoryList);
        return "news/newsList";
    }
    //根据页面查询新闻信息
    @RequestMapping(value ="/findNewsByPage")
    public String findNewsBbyPage(String keywords, Integer newsListCategoryId,
                                  @RequestParam(defaultValue = "1") Integer currPage,@RequestParam(defaultValue="10") Integer pageSize,Model model){
        List<Category> categoryList = categoryService.querryCategory();
        model.addAttribute("categoryList",categoryList);
        //获取新闻信息
        PageBean<News> pb = this.newsService.querryNewsList(keywords, newsListCategoryId, currPage, pageSize);
        model.addAttribute("pb",pb);
        model.addAttribute("keywords",keywords);
        model.addAttribute("newsListCategoryId",newsListCategoryId);
        model.addAttribute("currentPage",currPage);
        model.addAttribute("pageSize",pageSize);
        return "news/newsList";
    }

    //跳转到添加新闻页面
    @RequestMapping(value = "/toAddNews")
    public String toAddNews(News news,Model model){
       //获取新闻列表
        List<Category> categoryList = this.categoryService.querryCategory();
        model.addAttribute("categoryList",categoryList);
        return "news/addNews";
    }
    //添加新闻页面
    @RequestMapping(value = "/addNews",method = RequestMethod.POST)
    public String addNews(Model model,News news){
        Date date = new Date();
        news.setPublishTime(date);
        news.setPublishStatus("1");
        int rows = this.newsService.addNews(news);
        if(rows >0){
            return "redirect:findNewsByPage";
        }else{
            //获取新闻列表
            List<Category> categoryList = this.categoryService.querryCategory();
            model.addAttribute("categoryList",categoryList);
            model.addAttribute("news",news);
            return "news/addNews";
        }


    }

    //上线新闻发布状态
    @RequestMapping(value ="/setNewsPublishStatus")
    @ResponseBody
    public News setNewsPublishStatus(@RequestBody News news,Model model){
        int rows = this.newsService.updateNewsPublishStatus(news);
        if(rows >0){
            return news;
        }else{
            news.setPublishStatus("0");
            return news;
        }
    }
    //转向修改新闻页面
    @RequestMapping(value ="/toEditNews")
    public String toEditNews(Integer newsId,Model model){
        News news = this.newsService.querryNewsById(newsId);
        if(news != null){
            model.addAttribute("news",news);
            //获取新闻类型列表
            List<Category> categoryList = this.categoryService.querryCategory();
            model.addAttribute("categoryList",categoryList);
        }
        return "news/editNews";
    }
    //修改新闻页面
    @RequestMapping(value="/editNews",method=RequestMethod.POST)
    public String editNews(News news,Model model){
        Date date = new Date();
        news.setPublishStatus("1");
        news.setPublishTime(date);
        int rows = this.newsService.updateNews(news);
        if(rows >0){
            return "redirect:findNewsByPage";
        }else{
            //获取新闻类型列表
            List<Category> categoryList = this.categoryService.querryCategory();
            model.addAttribute("categoryList",categoryList);
            model.addAttribute("news",news);
            return "news/editNews";
        }
    }

    //删除新闻信息
    @RequestMapping(value="/delNews")
    @ResponseBody
    public News delNews(@RequestBody News news,Model model){
        System.out.println("news=>"+news);
        int rows = this.newsService.deleteNews(news.getNewsId());
        if(rows >0){
            return news;
        }else{
            news.setNewsId(0);
            return news;
        }
    }



}

