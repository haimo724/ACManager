package org.acmaster.entity;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class Solution implements Serializable{

    private static final long serialVersionUID = 1L;

    private int solutionId;

    private String solutionAuthorId;

    private String solutionTitle;

    private String solutionContent;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date solutionTime;

    private int isChecked;

    private byte isDeleted;

    private int goodCount;

    private String solutionFormat = String.valueOf(1);

    public Solution(int solutionId, String solutionAuthorId, String solutionTitle, String solutionContent, Date solutionTime, int isChecked, byte isDeleted, int goodCount, String solutionFormat) {
        this.solutionId = solutionId;
        this.solutionAuthorId = solutionAuthorId;
        this.solutionTitle = solutionTitle;
        this.solutionContent = solutionContent;
        this.solutionTime = solutionTime;
        this.isChecked = isChecked;
        this.isDeleted = isDeleted;
        this.goodCount = goodCount;
        this.solutionFormat = solutionFormat;
    }

    public Solution() {
    }

    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }

    public String getSolutionAuthorId() {
        return solutionAuthorId;
    }

    public void setSolutionAuthorId(String solutionAuthorId) {
        this.solutionAuthorId = solutionAuthorId;
    }

    public String getSolutionTitle() {
        return solutionTitle;
    }

    public void setSolutionTitle(String solutionTitle) {
        this.solutionTitle = solutionTitle;
    }

    public String getSolutionContent() {
        return solutionContent;
    }

    public void setSolutionContent(String solutionContent) {
        this.solutionContent = solutionContent;
    }

    public Date getSolutionTime() {
        return solutionTime;
    }

    public void setSolutionTime(Date solutionTime) {
        this.solutionTime = solutionTime;
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

    public String getSolutionFormat() {
        return solutionFormat;
    }

    public void setSolutionFormat(String solutionFormat) {
        this.solutionFormat = solutionFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return isChecked == solution.isChecked && isDeleted == solution.isDeleted && Objects.equals(solutionId, solution.solutionId) && Objects.equals(solutionAuthorId, solution.solutionAuthorId) && Objects.equals(solutionTitle, solution.solutionTitle) && Objects.equals(solutionContent, solution.solutionContent) && Objects.equals(solutionTime, solution.solutionTime) && Objects.equals(goodCount, solution.goodCount) && Objects.equals(solutionFormat, solution.solutionFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(solutionId, solutionAuthorId, solutionTitle, solutionContent, solutionTime, isChecked, isDeleted, goodCount, solutionFormat);
    }

    @Override
    public String toString() {
        return "Solution{" +
                "solutionId=" + solutionId +
                ", solutionAuthorId='" + solutionAuthorId + '\'' +
                ", solutionTitle='" + solutionTitle + '\'' +
                ", solutionContent='" + solutionContent + '\'' +
                ", solutionTime='" + solutionTime + '\'' +
                ", isChecked=" + isChecked +
                ", isDeleted=" + isDeleted +
                ", goodCount=" + goodCount +
                ", solutionFormat='" + solutionFormat + '\'' +
                '}';
    }
}
