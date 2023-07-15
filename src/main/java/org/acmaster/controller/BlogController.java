package org.acmaster.controller;

import org.acmaster.entity.Blog;
import org.acmaster.entity.Page;
import org.acmaster.entity.Result;

import org.acmaster.entity.UserTeam;
import org.acmaster.service.BlogService;

import org.acmaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.soap.Text;
import java.util.Date;

@RestController
// 访问目录
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    /**
     * 获取关于指定用户的博客
     * @param blogAuthorId
     * @return
     */
    @RequestMapping("/allUserBlog")
    public Result allUserBlog(String blogAuthorId){
        return blogService.allUserBlog(blogAuthorId);
    }

    @PostMapping("/good")
    public Result updateGoodCount(int blogId,int goodCount){
        return blogService.updateGoodCount(blogId,goodCount);
    }


    @GetMapping ("/all")
    public Result displayBlog(){
        return blogService.displayBlog();
    }


    @RequestMapping("/update")
    public Result updateBlog(Blog blog){
        return blogService.updateBlog(blog);
    }

    @PostMapping("/add")
    public Result addBlog(Blog blog){
        return blogService.addBlog(blog);
    }

    @PostMapping ("/delete")
    public Result deleteblog(int blogId){
        return  blogService.deleteBlog(blogId);
    }

    @RequestMapping("/check")
    public Result checkBlog(int blogId,int isChecked){
        return blogService.checkBlog(blogId,isChecked);
    }

    @GetMapping ("/query")
    public Result queryBlogById(int blogId){
        return blogService.queryblogById(blogId);
    }

    @GetMapping("/all1")
    public Result list(Page page, @RequestParam(value = "value", defaultValue = "") String value){
        return blogService.blogList(page,value);
    }
    @GetMapping("/page")
    public Result blogPage(Page page, @RequestParam(value="value",defaultValue = "") String value){
        return blogService.blogPage(page,value);
    }
}
