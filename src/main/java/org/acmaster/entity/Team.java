package org.acmaster.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @Author 王贤杰
 */
@Component
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
    私有属性
     */

    //分队系统编号
    private int teamId;
    //分队名字
    private String teamName;
    //宣传照片 url
    private String teamPhoto;
    //分队介绍
    private String teamIntro;
    //建队时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date teamTime;
    //分队队长
    private String teamCaptain;
    //分队管理员
    private String teamManager;
    //分队成员数量
    private int teamMember;
    //分队审核状态
    public byte teamStatus=0;
    //备注
    private String TeamRemark;

    //无参构造器
    public Team() {
    }

    //有参构造器
    public Team(int teamId, String teamName,
                     String teamPhoto, String teamIntro,
                     Date teamTime, String teamCaptain,
                     String teamManager, int teamMember,
                     byte teamStatus, String teamRemark) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamPhoto = teamPhoto;
        this.teamIntro = teamIntro;
        this.teamTime = teamTime;
        this.teamCaptain = teamCaptain;
        this.teamManager = teamManager;
        this.teamMember = teamMember;
        this.teamStatus = teamStatus;
        TeamRemark = teamRemark;
    }


    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamPhoto() {
        return teamPhoto;
    }

    public void setTeamPhoto(String teamPhoto) {
        this.teamPhoto = teamPhoto;
    }

    public String getTeamIntro() {
        return teamIntro;
    }

    public void setTeamIntro(String teamIntro) {
        this.teamIntro = teamIntro;
    }

    public Date getTeamTime() {
        return teamTime;
    }

    public void setTeamTime(Date teamTime) {
        this.teamTime = teamTime;
    }

    public String getTeamCaptain() {
        return teamCaptain;
    }

    public void setTeamCaptain(String teamCaptain) {
        this.teamCaptain = teamCaptain;
    }

    public String getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(String teamManager) {
        this.teamManager = teamManager;
    }

    public int getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(int teamMember) {
        this.teamMember = teamMember;
    }

    public byte getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(byte teamStatus) {
        this.teamStatus = teamStatus;
    }

    public String getTeamRemark() {
        return TeamRemark;
    }

    public void setTeamRemark(String teamRemark) {
        TeamRemark = teamRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return teamId == team.teamId && teamMember == team.teamMember && teamStatus == team.teamStatus && Objects.equals(teamName, team.teamName) && Objects.equals(teamPhoto, team.teamPhoto) && Objects.equals(teamIntro, team.teamIntro) && Objects.equals(teamTime, team.teamTime) && Objects.equals(teamCaptain, team.teamCaptain) && Objects.equals(teamManager, team.teamManager) && Objects.equals(TeamRemark, team.TeamRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, teamName, teamPhoto, teamIntro, teamTime, teamCaptain, teamManager, teamMember, teamStatus, TeamRemark);
    }

    @Override
    public String toString() {
        return "TeamInfo{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", teamPhoto='" + teamPhoto + '\'' +
                ", teamIntro='" + teamIntro + '\'' +
                ", teamTime=" + teamTime +
                ", teamCaptain='" + teamCaptain + '\'' +
                ", teamManager='" + teamManager + '\'' +
                ", teamMember=" + teamMember +
                ", teamStatus=" + teamStatus +
                ", TeamRemark='" + TeamRemark + '\'' +
                '}';
    }
}
