package org.acmaster.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 用于记录学生训练时长的实体
 */
public class UserTrain implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户训练id
     */
    private int userTrainId;

    /**
     * 用户学号
     */
    private String userId;

    /**
     * 用户名字
     */
    private String userName;

    /**
     * 训练日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date trainDate;

    /**
     * 训练时常
     */
    private double trainTime=0;

    /**
     * 审核状态
     */
    private int userTrainStatus=0;

    public UserTrain(int userTrainId, String userId, String userName, Date trainDate, double trainTime, int userTrainStatus) {
        this.userTrainId = userTrainId;
        this.userId = userId;
        this.userName = userName;
        this.trainDate = trainDate;
        this.trainTime = trainTime;
        this.userTrainStatus = userTrainStatus;
    }

    public UserTrain() {
    }

    public int getUserTrainId() {
        return userTrainId;
    }

    public void setUserTrainId(int userTrainId) {
        this.userTrainId = userTrainId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public double getTrainTime() {
        return trainTime;
    }

    public void setTrainTime(double trainTime) {
        this.trainTime = trainTime;
    }

    public int getUserTrainStatus() {
        return userTrainStatus;
    }

    public void setUserTrainStatus(int userTrainStatus) {
        this.userTrainStatus = userTrainStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserTrain userTrain = (UserTrain) o;
        return userTrainId == userTrain.userTrainId && userId == userTrain.userId && Double.compare(userTrain.trainTime, trainTime) == 0 && userTrainStatus == userTrain.userTrainStatus && Objects.equals(userName, userTrain.userName) && Objects.equals(trainDate, userTrain.trainDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userTrainId, userId, userName, trainDate, trainTime, userTrainStatus);
    }

    @Override
    public String toString() {
        return "UserTrain{" +
                "userTrainId=" + userTrainId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", trainDate=" + trainDate +
                ", trainTime=" + trainTime +
                ", userTrainStatus=" + userTrainStatus +
                '}';
    }
}
