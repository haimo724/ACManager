package org.acmaster.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.xml.soap.Text;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * 博客类，用于记录博客信息
 *
 * @author
 */
@Component
public class Blog implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 博客序号
     */
    private int blogId;

    private String blogAuthorId;

    /**
     * 博客标题
     */
    private String blogTitle;

    /**
     * 博客正文
     */
    private String blogText;

    /**
     * 博客发表时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date blogTime;

    /**
     * 博客审核状态，默认为待审核
     */
    private int isChecked;

    /**
     *博客存在状态,默认未被删除
     */
    private byte isDeleted;

    /**
     * 博客获赞数，默认为0
     */
    private int goodCount;

    /**
     * 博客格式
     */
    private String blogFormat;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogAuthorId() {
        return blogAuthorId;
    }

    public void setBlogAuthorId(String blogAuthorId) {
        this.blogAuthorId = blogAuthorId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    public Date getBlogTime() {
        return blogTime;
    }

    public void setBlogTime(Date blogTime) {
        this.blogTime = blogTime;
    }

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }

    public byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(int goodCount) {
        this.goodCount = goodCount;
    }

    public String getBlogFormat() {
        return blogFormat;
    }

    public void setBlogFormat(String blogFormat) {
        this.blogFormat = blogFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return blogId == blog.blogId && isChecked == blog.isChecked && isDeleted == blog.isDeleted && goodCount == blog.goodCount && Objects.equals(blogAuthorId, blog.blogAuthorId) && Objects.equals(blogTitle, blog.blogTitle) && Objects.equals(blogText, blog.blogText) && Objects.equals(blogTime, blog.blogTime) && Objects.equals(blogFormat, blog.blogFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blogId, blogAuthorId, blogTitle, blogText, blogTime, isChecked, isDeleted, goodCount, blogFormat);
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", blogAuthorId='" + blogAuthorId + '\'' +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogText=" + blogText +
                ", blogTime=" + blogTime +
                ", isChecked=" + isChecked +
                ", isDeleted=" + isDeleted +
                ", goodCount=" + goodCount +
                ", blogFormat='" + blogFormat + '\'' +
                '}';
    }
}
