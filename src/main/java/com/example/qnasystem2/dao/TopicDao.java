package com.example.qnasystem2.dao;

import com.example.qnasystem2.model.Topic;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collection;

public class TopicDao {

    private static ConcurrentHashMap<Integer, Topic> topicDB = new ConcurrentHashMap<>();
    private static int idCounter = 1;

    // 添加话题
    public Topic addTopic(Topic topic) {
        topic.setTopicid(idCounter++);
        topicDB.put(topic.getTopicid(), topic);
        return topic;
    }

    // 根据ID查询话题
    public Topic getTopicById(int id) {
        return topicDB.get(id);
    }

    // 更新话题
    public void updateTopic(Topic topic) {
        topicDB.put(topic.getTopicid(), topic);
    }

    // 删除话题
    public void deleteTopic(int id) {
        topicDB.remove(id);
    }

    // 获取所有话题
    public Collection<Topic> getAllTopics() {
        return topicDB.values();
    }
}
