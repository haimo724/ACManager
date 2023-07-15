package org.acmaster.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

/**
 * 对应News的实体类。
 * @Author 马锦昭
 */
public class News {

  private Integer newsId;
  private String newsTitle;
  private String newsContent;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date newsTime;
  private Integer newsLevel;
  private Integer newsType;
  private String newsAuthorId;
  private String newsPhoto;
  private String newsViews;
  private String newsComment;
  private int newsCheck;
  private Integer newsFormat;

  public News() {
  }

  public News(int newsId, String newsTitle, String newsContent, Date newsTime, Integer newsLevel, Integer newsType, String newsAuthorId, String newsPhoto, String newsViews, String newsComment, int newsCheck, Integer newsFormat) {
    this.newsId = newsId;
    this.newsTitle = newsTitle;
    this.newsContent = newsContent;
    this.newsTime = newsTime;
    this.newsLevel = newsLevel;
    this.newsType = newsType;
    this.newsAuthorId = newsAuthorId;
    this.newsPhoto = newsPhoto;
    this.newsViews = newsViews;
    this.newsComment = newsComment;
    this.newsCheck = newsCheck;
    this.newsFormat = newsFormat;
  }

  public News(String newsTitle,Date newsTime){
    this.newsTitle = newsTitle;
    this.newsTime = newsTime;
  }

  public int getNewsId() {
    return newsId;
  }

  public void setNewsId(int newsId) {
    this.newsId = newsId;
  }

  public String getNewsTitle() {
    return newsTitle;
  }

  public void setNewsTitle(String newsTitle) {
    this.newsTitle = newsTitle;
  }

  public String getNewsContent() {
    return newsContent;
  }

  public void setNewsContent(String newsContent) {
    this.newsContent = newsContent;
  }

  public Date getNewsTime() {
    return newsTime;
  }

  public void setNewsTime(Date newsTime) {
    this.newsTime = newsTime;
  }

  public Integer getNewsLevel() {
    return newsLevel;
  }

  public void setNewsLevel(Integer newsLevel) {
    this.newsLevel = newsLevel;
  }

  public Integer getNewsType() {
    return newsType;
  }

  public void setNewsType(Integer newsType) {
    this.newsType = newsType;
  }

  public String getNewsAuthorId() {
    return newsAuthorId;
  }

  public void setNewsAuthorId(String newsAuthorId) {
    this.newsAuthorId = newsAuthorId;
  }

  public String getNewsPhoto() {
    return newsPhoto;
  }

  public void setNewsPhoto(String newsPhoto) {
    this.newsPhoto = newsPhoto;
  }

  public String getNewsViews() {
    return newsViews;
  }

  public void setNewsViews(String newsViews) {
    this.newsViews = newsViews;
  }

  public String getNewsComment() {
    return newsComment;
  }

  public void setNewsComment(String newsComment) {
    this.newsComment = newsComment;
  }

  public int getNewsCheck() {
    return newsCheck;
  }

  public void setNewsCheck(int newsCheck) {
    this.newsCheck = newsCheck;
  }

  public Integer getNewsFormat() {
    return newsFormat;
  }

  public void setNewsFormat(Integer newsFormat) {
    this.newsFormat = newsFormat;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    News news = (News) o;
    return newsId == news.newsId && newsLevel == news.newsLevel && newsType == news.newsType && newsCheck == news.newsCheck && newsFormat == news.newsFormat && Objects.equals(newsTitle, news.newsTitle) && Objects.equals(newsContent, news.newsContent) && Objects.equals(newsTime, news.newsTime) && Objects.equals(newsAuthorId, news.newsAuthorId) && Objects.equals(newsPhoto, news.newsPhoto) && Objects.equals(newsViews, news.newsViews) && Objects.equals(newsComment, news.newsComment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newsId, newsTitle, newsContent, newsTime, newsLevel, newsType, newsAuthorId, newsPhoto, newsViews, newsComment, newsCheck, newsFormat);
  }

  @Override
  public String toString() {
    return "News{" +
            + newsId +
            ", " + newsTitle + '\'' +
            ", " + newsContent + '\'' +
            ", " + newsTime + '\'' +
            ", " + newsLevel +
            ", " + newsType +
            ", " + newsAuthorId +
            ", '" + newsPhoto + '\'' +
            ", '" + newsViews + '\'' +
            ", '" + newsComment + '\'' +
            ", " + newsCheck +
            ", " + newsFormat +
            '}';
  }
}
