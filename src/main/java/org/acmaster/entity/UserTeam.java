package org.acmaster.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public class UserTeam {

    /**
     * 用户分队id
     */
    private int userTeamId;

    /**
     * 用户学工号
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 分队序号
     */
    private int teamId;

    /**
     * 用户入队时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date userTeamTime;

    /**
     * 队伍所有成员训练总时长
     */
    private double teamTrain;

    /**
     * 用户入队审核状态
     */
    private int userTeamStatus=0;

    public UserTeam(int userTeamId, String userId, String userName, int teamId, Date userTeamTime, double teamTrain, int userTeamStatus) {
        this.userTeamId = userTeamId;
        this.userId = userId;
        this.userName = userName;
        this.teamId = teamId;
        this.userTeamTime = userTeamTime;
        this.teamTrain = teamTrain;
        this.userTeamStatus = userTeamStatus;
    }

    public UserTeam() {
    }

    public int getUserTeamId() {
        return userTeamId;
    }

    public void setUserTeamId(int userTeamId) {
        this.userTeamId = userTeamId;
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

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Date getUserTeamTime() {
        return userTeamTime;
    }

    public void setUserTeamTime(Date userTeamTime) {
        this.userTeamTime = userTeamTime;
    }

    public double getTeamTrain() {
        return teamTrain;
    }

    public void setTeamTrain(double teamTrain) {
        this.teamTrain = teamTrain;
    }

    public int getUserTeamStatus() {
        return userTeamStatus;
    }

    public void setUserTeamStatus(int userTeamStatus) {
        this.userTeamStatus = userTeamStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserTeam userTeam = (UserTeam) o;
        return userTeamId == userTeam.userTeamId && teamId == userTeam.teamId && Double.compare(userTeam.teamTrain, teamTrain) == 0 && userTeamStatus == userTeam.userTeamStatus && Objects.equals(userId, userTeam.userId) && Objects.equals(userName, userTeam.userName) && Objects.equals(userTeamTime, userTeam.userTeamTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userTeamId, userId, userName, teamId, userTeamTime, teamTrain, userTeamStatus);
    }

    @Override
    public String toString() {
        return "userTeam{" +
                "userTeamId=" + userTeamId +
                ", userSysId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", teamId=" + teamId +
                ", userTeamTime=" + userTeamTime +
                ", teamTrain=" + teamTrain +
                ", userTeamStatus=" + userTeamStatus +
                '}';
    }
}
