package com.example.qnasystem2.model;

import java.util.Date;

public class Topic {
    private int topicid;             // 话题ID
    private String title;       // 话题标题
    private String content;     // 话题内容
    private int userid;         // 发布用户ID
    private Date createTime;    // 创建时间
    private String username;

    public Topic() {
    }

    public Topic(int topicid, String title, String content, int userid, Date createTime, String username) {
        this.topicid = topicid;
        this.title = title;
        this.content = content;
        this.userid = userid;
        this.createTime = createTime;
        this.username = username;
    }

    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
