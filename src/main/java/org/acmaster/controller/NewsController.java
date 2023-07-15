package org.acmaster.controller;

import org.acmaster.entity.News;
import org.acmaster.entity.Page;
import org.acmaster.entity.Result;
import org.acmaster.entity.User;
import org.acmaster.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// 访问目录
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;


    @GetMapping("/select")
    public Result select(Integer newsId){
        Result result ;
        result = newsService.select(newsId);
        return  result;
    }

    @PostMapping("/insert")
    public Result insert(News news){
        Result result;
        result = newsService.insertNews(news);
        return result;
    }

    @PostMapping("/delete")
    public Result delete(Integer newsId){
        Result result;
        result = newsService.deleteNewsById(newsId);
        return result;
    }
    @PostMapping("/update")
    public  Result update(News news){
        Result result;
        result = newsService.updateNewsById(news);
        return  result;
    }

    /**
     * 获取所有新闻
     * @return
     */
    @GetMapping("/allNews")
    public Result allNews(){
        return newsService.allNews();
    }

    /**
     * 获取分页新闻列表
     * @param page
     * @param value
     * @return
     */
    @GetMapping("/all")
    public Result list(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        return newsService.newsList(page,value);
    }

    /**
     * 获取页面信息
     * @param page
     * @param value
     * @return
     */
    @GetMapping("/page")
    public Result newsPage(Page page, @RequestParam(value="value",defaultValue = "") String value){
        return newsService.newsPage(page,value);
    }
}
