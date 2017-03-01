package com.message.entity.message;

import com.message.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @Author Alcott Hawk
 * @Date 2/27/2017
 */
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity{

    private String messageId;
    private String content;
    private String userId;
    private String publishTime;
    private int agree;
    private int disagree;
    private boolean show;
    private boolean delete;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Lob
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    @Column(name = "isShow")
    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    @Column(name = "isDelete")
    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public int getAgree() {
        return agree;
    }

    public void setAgree(int agree) {
        this.agree = agree;
    }

    public int getDisagree() {
        return disagree;
    }

    public void setDisagree(int disagree) {
        this.disagree = disagree;
    }
}
