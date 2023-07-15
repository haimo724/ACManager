package org.acmaster.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 王海涵
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户系统编号
     */
    private int userSysId;

    /**
     * 用户学工号
     */
    private String userId;

    /**
     * 用户密码(MD5)
     */
    private String userPassword;

    /**
     * 用户名字
     */
    private String userName;

    /**
     * 手机号码
     */
    private String userPhone;

    /**
     * 电子邮箱
     */
    private String userEmail;

    /**
     * 用户性别
     */
    private String userSex;

    /**
     * 用户照片
     */
    private String userPhoto;

    /**
     * 用户所在学院
     */
    private String userCollege;

    /**
     * 用户所在专业
     */
    private String userMajor;

    /**
     * 用户身份
     */
    private Integer userStatus;

    /**
     * 博客数量
     */
    private Integer userBlog;

    /**
     * 解题数量
     */
    private Integer userSolutionNum;

    public User(int userSysId, String userId, String userPassword, String userName, String userPhone, String userEmail, String userSex, String userPhoto, String userCollege, String userMajor, Integer userStatus, Integer userBlog, Integer userSolutionNum) {
        this.userSysId = userSysId;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userSex = userSex;
        this.userPhoto = userPhoto;
        this.userCollege = userCollege;
        this.userMajor = userMajor;
        this.userStatus = userStatus;
        this.userBlog = userBlog;
        this.userSolutionNum = userSolutionNum;
    }

    public User() {
    }

    public int getUserSysId() {
        return userSysId;
    }

    public void setUserSysId(int userSysId) {
        this.userSysId = userSysId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserCollege() {
        return userCollege;
    }

    public void setUserCollege(String userCollege) {
        this.userCollege = userCollege;
    }

    public String getUserMajor() {
        return userMajor;
    }

    public void setUserMajor(String userMajor) {
        this.userMajor = userMajor;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserBlog() {
        return userBlog;
    }

    public void setUserBlog(Integer userBlog) {
        this.userBlog = userBlog;
    }

    public Integer getUserSolutionNum() {
        return userSolutionNum;
    }

    public void setUserSolutionNum(Integer userSolutionNum) {
        this.userSolutionNum = userSolutionNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return userSysId == user.userSysId && Objects.equals(userId, user.userId) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userName, user.userName) && Objects.equals(userPhone, user.userPhone) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userSex, user.userSex) && Objects.equals(userPhoto, user.userPhoto) && Objects.equals(userCollege, user.userCollege) && Objects.equals(userMajor, user.userMajor) && Objects.equals(userStatus, user.userStatus) && Objects.equals(userBlog, user.userBlog) && Objects.equals(userSolutionNum, user.userSolutionNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userSysId, userId, userPassword, userName, userPhone, userEmail, userSex, userPhoto, userCollege, userMajor, userStatus, userBlog, userSolutionNum);
    }

    @Override
    public String toString() {
        return "User{" +
                "userSysId=" + userSysId +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", userCollege='" + userCollege + '\'' +
                ", userMajor='" + userMajor + '\'' +
                ", userStatus=" + userStatus +
                ", userBlog=" + userBlog +
                ", userSolutionNum=" + userSolutionNum +
                '}';
    }

}