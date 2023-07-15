package org.acmaster.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * 活动实体类
 */
public class Activity {

  private int activityId;
  private String activityAuthorId;
  private String activityTitle;
  private String activityContent;
  private String activityPhoto;
  private String activityOrganizer;
  private String activityCharge;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date  activityStart;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date  activityEnd;
  private int activityCheck;

  public Activity(int activityId, String activityAuthorId, String activityTitle, String activityContent, String activityPhoto, String activityOrganizer, String activityCharge, Date activityStart, Date activityEnd, int activityCheck) {
    this.activityId = activityId;
    this.activityAuthorId = activityAuthorId;
    this.activityTitle = activityTitle;
    this.activityContent = activityContent;
    this.activityPhoto = activityPhoto;
    this.activityOrganizer = activityOrganizer;
    this.activityCharge = activityCharge;
    this.activityStart = activityStart;
    this.activityEnd = activityEnd;
    this.activityCheck = activityCheck;
  }

  public Activity() {
  }

  public int getActivityId() {
    return activityId;
  }

  public void setActivityId(int activityId) {
    this.activityId = activityId;
  }

  public String getActivityAuthorId() {
    return activityAuthorId;
  }

  public void setActivityAuthorId(String activityAuthorId) {
    this.activityAuthorId = activityAuthorId;
  }

  public String getActivityTitle() {
    return activityTitle;
  }

  public void setActivityTitle(String activityTitle) {
    this.activityTitle = activityTitle;
  }

  public String getActivityContent() {
    return activityContent;
  }

  public void setActivityContent(String activityContent) {
    this.activityContent = activityContent;
  }

  public String getActivityPhoto() {
    return activityPhoto;
  }

  public void setActivityPhoto(String activityPhoto) {
    this.activityPhoto = activityPhoto;
  }

  public String getActivityOrganizer() {
    return activityOrganizer;
  }

  public void setActivityOrganizer(String activityOrganizer) {
    this.activityOrganizer = activityOrganizer;
  }

  public String getActivityCharge() {
    return activityCharge;
  }

  public void setActivityCharge(String activityCharge) {
    this.activityCharge = activityCharge;
  }

  public Date getActivityStart() {
    return activityStart;
  }

  public void setActivityStart(Date activityStart) {
    this.activityStart = activityStart;
  }

  public Date getActivityEnd() {
    return activityEnd;
  }

  public void setActivityEnd(Date activityEnd) {
    this.activityEnd = activityEnd;
  }

  public int getActivityCheck() {
    return activityCheck;
  }

  public void setActivityCheck(int activityCheck) {
    this.activityCheck = activityCheck;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Activity activity = (Activity) o;
    return activityId == activity.activityId && activityCheck == activity.activityCheck && Objects.equals(activityAuthorId, activity.activityAuthorId) && Objects.equals(activityTitle, activity.activityTitle) && Objects.equals(activityContent, activity.activityContent) && Objects.equals(activityPhoto, activity.activityPhoto) && Objects.equals(activityOrganizer, activity.activityOrganizer) && Objects.equals(activityCharge, activity.activityCharge) && Objects.equals(activityStart, activity.activityStart) && Objects.equals(activityEnd, activity.activityEnd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activityId, activityAuthorId, activityTitle, activityContent, activityPhoto, activityOrganizer, activityCharge, activityStart, activityEnd, activityCheck);
  }

  @Override
  public String toString() {
    return "Activity{" +
            "activityId=" + activityId +
            ", activityAuthorId='" + activityAuthorId + '\'' +
            ", activityTitle='" + activityTitle + '\'' +
            ", activityContent='" + activityContent + '\'' +
            ", activityPhoto='" + activityPhoto + '\'' +
            ", activityOrganizer='" + activityOrganizer + '\'' +
            ", activityCharge=" + activityCharge +
            ", activityStart=" + activityStart +
            ", activityEnd=" + activityEnd +
            ", activityCheck=" + activityCheck +
            '}';
  }
}
