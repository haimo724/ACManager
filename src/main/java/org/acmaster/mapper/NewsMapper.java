package org.acmaster.mapper;

import org.acmaster.entity.News;
import org.acmaster.entity.Page;
import org.acmaster.entity.Team;
import org.acmaster.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsMapper {

    //查询新闻
    News queryNewsByID(Integer newsId);
    //删除新闻
    void deleteNewsById(Integer newsId);
    //插入新闻
    void insertNews(News news);
    //更新新闻
    void updateNewsById(News news);

    long queryCount();

    long queryCountBySearch(String value);

    List<News> queryAll();

    List<News> queryListByPage(Page page);

    List<News> queryListByPageAndSearch(@Param("page") Page page, @Param("value") String value);

}
