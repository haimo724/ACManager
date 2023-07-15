package org.acmaster.service;

import org.acmaster.entity.*;
import org.acmaster.mapper.NewsMapper;
import org.acmaster.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsMapper newsMapper;

    /**
     * 展示所有新闻
     * @return
     */
    public  Result all() {
        Result result = new Result();
        List<News> newsList;
        newsList = newsMapper.queryAll();
        result.setMessage(newsList.toString());
        return result;
    }

    /**
     * 查询新闻
     * @param newsId
     * @return
     */
    public Result select(Integer newsId) {
        Result result = new Result();
        News news = newsMapper.queryNewsByID(newsId);
        String message = news.toString();
        result.setMessage(message);
        return result;
    }

    /**
     * 添加新闻
     * @param newsId
     * @param newsTitle
     * @param newsContent
     * @param newsTime
     * @param newsLevel
     * @param newsType
     * @param newsAuthor
     * @param newsPhoto
     * @param newsViews
     * @param newsComment
     * @param newsCheck
     * @param newsFormat
     * @return
     */
    public Result insertNews(News news) {
        Result result = new Result();
        if(ValidateUtil.isEmpty(news.getNewsTitle())||
                ValidateUtil.isEmpty(news.getNewsContent())||
                ValidateUtil.isEmpty(news.getNewsTime())||
                ValidateUtil.isEmpty(news.getNewsAuthorId())||
                ValidateUtil.isEmpty(news.getNewsCheck())){
            result.setMessage("新闻标题、新闻内容、新闻发布时间、新闻作者Id、新闻审核状态均不能为空！");
        }else{
            newsMapper.insertNews(news);
            result.setMessage("新闻发布成功!");
        }
        return result;
    }

    /**
     * 删除新闻
     * @param newsId
     * @return
     */
    public Result deleteNewsById(Integer newsId) {
        Result result = new Result();
        newsMapper.deleteNewsById(newsId);
        result.setMessage("删除成功");
        return result;
    }

    /**
     * 修改新闻
     * @param news
     * @return result
     */
    public Result updateNewsById(News news) {
        Result result = new Result();
        if(ValidateUtil.isEmpty(newsMapper.queryNewsByID(news.getNewsId()))){
            result.setMessage("该Id对应新闻不存在");
        }else{
            newsMapper.updateNewsById(news);
            result.setMessage("修改成功");
        }
        return result;
    }

    public Result allNews(){
        Result result=new Result();
        List<News> news;
        news=newsMapper.queryAll();
        result.setData(news);
        return result;
    }
    /**
     * 获取新闻列表
     * @param page
     * @param value
     * @return
     */
    public Result newsList(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        Result result=new Result();
        List<News> news;
        if(ValidateUtil.isEmpty(value)){
            news=newsMapper.queryListByPage(page);
        }else{
            news=newsMapper.queryListByPageAndSearch(page,value);
        }
        result.setData(news);
        return result;
    }

    /**
     * 获取页面属性
     * @param page
     * @param value
     * @return
     */
    public Result newsPage(Page page, String value){
        Result result=new Result();
        /*获取总条数*/
        long count;
        if (ValidateUtil.isEmpty(value)) {
            count = newsMapper.queryCount();
        } else {
            count = newsMapper.queryCountBySearch(value);
        }
        int totalPage = (int) Math.ceil((double) count / page.getSize());
        page.setTotalPage(totalPage);
        result.setData(page);
        return result;
    }
}
