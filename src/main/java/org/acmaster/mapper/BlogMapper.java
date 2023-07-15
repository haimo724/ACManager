package org.acmaster.mapper;

import org.acmaster.entity.*;
import org.acmaster.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.xml.soap.Text;
import java.util.Date;
import java.util.List;

@Mapper
public interface BlogMapper {
    Blog queryBlogByID(int blogId);

    void updateById(int blogId,int isChecked);
    
    List<Blog> queryBlogs();

    List<Blog> queryBlogByBlogAuthorId(String blogAuthorId);

    void updateGoodCount(int blogId,int goodCount);

    boolean updateBlog(Blog blog);

    void addBlog(Blog blog);

    boolean deleteBlog(int blogId);

    long queryCount();

    long queryCountBySearch(String value);

    List<Blog> queryListByPage(Page page);

    List<Blog> queryListByPageAndSearch(@Param("page") Page page, @Param("value") String value);
}
