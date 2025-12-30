package com.example.qnasystem2.model;

import java.util.Date;

public class Reply {
    private int replyid;             // 回复ID
    private int topicid;        // 所属话题ID
    private int userid;         // 回复用户ID
    private String content;     // 回复内容
    private Date createTime;    // 回复时间

    public Reply() {
    }

    public Reply(int replyid, int topicid, int userid, String content, Date createTime) {
        this.replyid = replyid;
        this.topicid = topicid;
        this.userid = userid;
        this.content = content;
        this.createTime = createTime;
    }

    public int getReplyid() {
        return replyid;
    }

    public void setReplyid(int replyid) {
        this.replyid = replyid;
    }

    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
