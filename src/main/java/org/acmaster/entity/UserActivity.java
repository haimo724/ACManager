package org.acmaster.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class UserActivity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int UAID;

    private String userId;

    private String userName;

    private int activityid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date UATime;

    private int UAStatus;

    public UserActivity() {
    }

    public UserActivity(int UAID, String userId, String userName, int activityid, Date UATime, int UAStatus) {
        this.UAID = UAID;
        this.userId = userId;
        this.userName = userName;
        this.activityid = activityid;
        this.UATime = UATime;
        this.UAStatus = UAStatus;
    }

    public int getUAID() {
        return UAID;
    }

    public void setUAID(int UAID) {
        this.UAID = UAID;
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

    public int getActivityid() {
        return activityid;
    }

    public void setActivityid(int activityid) {
        this.activityid = activityid;
    }

    public Date getUATime() {
        return UATime;
    }

    public void setUATime(Date UATime) {
        this.UATime = UATime;
    }

    public int getUAStatus() {
        return UAStatus;
    }

    public void setUAStatus(int UAStatus) {
        this.UAStatus = UAStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserActivity that = (UserActivity) o;
        return UAID == that.UAID && userId == that.userId && activityid == that.activityid && UAStatus == that.UAStatus && Objects.equals(userName, that.userName) && Objects.equals(UATime, that.UATime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UAID, userId, userName, activityid, UATime, UAStatus);
    }

    @Override
    public String toString() {
        return "Useractivity{" +
                "UAID=" + UAID +
                ", userSysID=" + userId +
                ", userName='" + userName + '\'' +
                ", activityid=" + activityid +
                ", UATime=" + UATime +
                ", UAStatus=" + UAStatus +
                '}';
    }
}
