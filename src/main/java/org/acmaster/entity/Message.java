package org.acmaster.entity;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.xml.soap.Text;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 留言类
 */
@Component
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    private int messageId;

    private String messageAuthorId;

    private String messageTitle;

    private String messageContent;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date messageTime;

    private int messageSupport=0;

    private int msgCheck;

    private byte mesFormat;

    private int isDeleted;

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }


    public Message() {
    }

    public Message(int messageId, String messageAuthorId, String messageTitle, String messageContent, Date messageTime, int messageSupport, int msgCheck, byte mesFormat,int isDeleted) {
        this.messageId = messageId;
        this.messageAuthorId = messageAuthorId;
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
        this.messageTime = messageTime;
        this.messageSupport = messageSupport;
        this.msgCheck = msgCheck;
        this.mesFormat = mesFormat;
        this.isDeleted = isDeleted;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageAuthorId() {
        return messageAuthorId;
    }

    public void setMessageAuthorId(String messageAuthorId) {
        this.messageAuthorId = messageAuthorId;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public int getMessageSupport() {
        return messageSupport;
    }

    public void setMessageSupport(int messageSupport) {
        this.messageSupport = messageSupport;
    }

    public int getMesCheck() {
        return msgCheck;
    }

    public void setMesCheck(int mesCheck) {
        this.msgCheck = msgCheck;
    }

    public byte getMesFormat() {
        return mesFormat;
    }

    public void setMesFormat(byte mesFormat) {
        this.mesFormat = mesFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return messageId == message.messageId && messageSupport == message.messageSupport && msgCheck == message.msgCheck && mesFormat == message.mesFormat && Objects.equals(messageAuthorId, message.messageAuthorId) && Objects.equals(messageTitle, message.messageTitle) && Objects.equals(messageContent, message.messageContent) && Objects.equals(messageTime, message.messageTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, messageAuthorId, messageTitle, messageContent, messageTime, messageSupport, msgCheck, mesFormat);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", messageAuthor=" + messageAuthorId +
                ", messageTitle='" + messageTitle + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageTime=" + messageTime +
                ", messageSupport=" + messageSupport +
                ", msgCheck=" + msgCheck +
                ", mesFormat=" + mesFormat +
                '}';
    }
}
