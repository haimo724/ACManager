package org.acmaster.service;

import org.acmaster.entity.*;
import org.acmaster.entity.Result;
import org.acmaster.mapper.BlogMapper;
import org.acmaster.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.soap.Text;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;


    /**
     * 展示所有审核通过且没被删除的的博客
     * @return
     */
    public  Result displayBlog() {
        Result result=new Result();
        try {
            List<Blog> blogs = blogMapper.queryBlogs();
            result.setData(blogs);
        }catch (Exception e){
            result.setCode(0);
            result.setData(e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取关于指定用户的博客
     * @param blogAuthorId
     * @return
     */
    public Result allUserBlog(String blogAuthorId){
        Result result=new Result();
        result.setData(0);
        try{
            if(ValidateUtil.isEmpty(blogAuthorId)){
                result.setMessage("尚未登录，请先登录！");
            }else{
                List<Blog> blogs=blogMapper.queryBlogByBlogAuthorId(blogAuthorId);
                result.setData(blogs);
            }
        }catch(Exception e){
            result.setMessage("网络连接异常");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新点赞数
     * @param blogId
     * @return
     */
    public  Result updateGoodCount(int blogId,int goodCount) {
        Result result=new Result();
        try {
            Blog blogExit=blogMapper.queryBlogByID(blogId);
            if(blogExit!=null){
                blogExit.setGoodCount(goodCount);
                blogMapper.updateGoodCount(blogId,goodCount);
            }
        }catch (Exception e){
            result.setMessage("error");
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 更新一个博客内容
     * @param blog
     * @return
     */
    public Result updateBlog(Blog blog) {
        Result result=new Result();

        boolean b = blogMapper.updateBlog(blog);
        if (b) {
            result.setCode(200);
            result.setMessage("保存数据成功");
        }else
        {
            result.setCode(0);
            result.setMessage("保存数据失败,请检查提交内容");
        }
        return result;
    }


    /**
     * 删除一个博客
     * @param blogId
     * @return
     */
    public Result deleteBlog(int blogId) {
        Result result=new Result();
        try{
            if(ValidateUtil.isEmpty(blogId)){
                result.setMessage("博客Id不能为空！");
            }else{
                boolean b=blogMapper.deleteBlog(blogId);
                if (b) {
                    result.setCode(200);
                    result.setMessage("删除数据成功");
                } else {
                    result.setCode(0);
                    result.setMessage("删除数据失败,请检查提交内容");
                }
            }
        }catch (Exception e){
            result.setMessage("error");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 通过博客id查询博客信息
     * @param blogId
     * @return
     */
    public Result queryblogById(int blogId) {
        Result result=new Result();
        try {
            Blog blog=blogMapper.queryBlogByID(blogId);
            result.setCode(200);
            if (blog != null) {
                result.setData(blog);
            } else {
                result.setMessage("不存在该博客");
            }
        }catch (Exception e){
            result.setCode(0);
            result.setData(e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * 添加一个博客
     * @return
     */
    public Result addBlog(Blog blog) {
        Result result=new Result();
        try {
            if(ValidateUtil.isEmpty(blog.getBlogAuthorId())){
                result.setMessage("尚未登录，请先登录");
            }else if(ValidateUtil.isEmpty(blog.getBlogTitle())||
                    ValidateUtil.isEmpty(blog.getBlogText())||
                    ValidateUtil.isEmpty(blog.getBlogTime())||
                    ValidateUtil.isEmpty(blog.getBlogFormat())){
                result.setMessage("博客标题、正文、格式、时间均不能为空！");
            }else{
                blogMapper.addBlog(blog);
                result.setCode(200);
                result.setMessage("提交成功！");
            }
        }catch (Exception e){
            result.setMessage("网络连接异常，请重试！");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 审核博客
     * @param blogId
     * @param isChecked
     * @return
     */
    public Result checkBlog(int blogId,int isChecked){
        Result result = new Result();
        try{
            if(ValidateUtil.isEmpty(blogId)){
                result.setMessage("博客Id不能为空！");
            }else{
                if(ValidateUtil.isEmpty(blogMapper.queryBlogByID(blogId))){
                    result.setMessage("该Id对应博客不存在！");
                }else{
                    blogMapper.updateById(blogId,isChecked);
                    result.setMessage("更新成功");
                }
            }
        } catch (Exception e){
            result.setMessage(e.getMessage());
            result.setCode(0);
        }
        return result;
    }

    /**
     * 获取博客列表
     * @param page
     * @param value
     * @return
     */
    public Result blogList(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        Result result=new Result();
        List<Blog> blogs;
        if(ValidateUtil.isEmpty(value)){
            blogs=blogMapper.queryListByPage(page);
        }else{
            blogs=blogMapper.queryListByPageAndSearch(page,value);
        }
        result.setData(blogs);
        return result;
    }

    /**
     * 获取页面属性
     * @param page
     * @param value
     * @return
     */
    public Result blogPage(Page page, String value){
        Result result=new Result();
        /*获取总条数*/
        long count;
        if (ValidateUtil.isEmpty(value)) {
            count = blogMapper.queryCount();
        } else {
            count = blogMapper.queryCountBySearch(value);
        }
        int totalPage = (int) Math.ceil((double) count / page.getSize());
        page.setTotalPage(totalPage);
        result.setData(page);
        return result;
    }
}
