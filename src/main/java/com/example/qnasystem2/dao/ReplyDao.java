package com.example.qnasystem2.dao;

import com.example.qnasystem2.model.Reply;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.stream.Collectors;

public class ReplyDao {

    private static ConcurrentHashMap<Integer, Reply> replyDB = new ConcurrentHashMap<>();
    private static int idCounter = 1;

    // 添加回复
    public Reply addReply(Reply reply) {
        reply.setReplyid(idCounter++);
        replyDB.put(reply.getReplyid(), reply);
        return reply;
    }

    // 根据ID查询回复
    public Reply getReplyById(int id) {
        return replyDB.get(id);
    }

    // 更新回复
    public void updateReply(Reply reply) {
        replyDB.put(reply.getReplyid(), reply);
    }

    // 删除回复
    public void deleteReply(int id) {
        replyDB.remove(id);
    }

    // 获取某个话题的所有回复
    public Collection<Reply> getRepliesByTopicId(int topicId) {
        return replyDB.values().stream()
                .filter(r -> r.getTopicid() == topicId)
                .collect(Collectors.toList());
    }

    // 获取所有回复
    public Collection<Reply> getAllReplies() {
        return replyDB.values();
    }
}
