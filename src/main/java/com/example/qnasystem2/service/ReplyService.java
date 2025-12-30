package com.example.qnasystem2.service;

import com.example.qnasystem2.dao.ReplyDao;
import com.example.qnasystem2.model.Reply;
import java.util.Collection;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    private ReplyDao replyDao = new ReplyDao();

    // 添加回复
    public Reply addReply(int topicId, int userId, String content) {
        Reply reply = new Reply();
        reply.setTopicid(topicId);
        reply.setUserid(userId);
        reply.setContent(content);
        reply.setCreateTime(new Date());

        return replyDao.addReply(reply);
    }

    // 获取某话题所有回复
    public Collection<Reply> getRepliesByTopicId(int topicId) {
        return replyDao.getRepliesByTopicId(topicId);
    }
}
