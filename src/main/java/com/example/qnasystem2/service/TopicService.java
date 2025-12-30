package com.example.qnasystem2.service;

import com.example.qnasystem2.dao.TopicDao;
import com.example.qnasystem2.model.Topic;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    private TopicDao topicDao = new TopicDao();

    // 话题线程管理
    private ConcurrentHashMap<Integer, Thread> topicThreads = new ConcurrentHashMap<>();

    // 创建话题并启动独立线程
    public Topic createTopic(String title, String content, int userId, String username) {
        Topic topic = new Topic();
        topic.setTitle(title);
        topic.setContent(content);
        topic.setUserid(userId);
        topic.setCreateTime(new Date());
        topic.setUsername(username);

        topic = topicDao.addTopic(topic);

        // 为每个话题创建独立线程
        int topicid = topic.getTopicid();
        Thread topicThread = new Thread(() -> runTopic(topicid));
        topicThread.start();

        topicThreads.put(topic.getTopicid(), topicThread);

        return topic;
    }

    // 获取所有话题
    public Collection<Topic> getAllTopics() {
        return topicDao.getAllTopics();
    }

    // 根据ID获取话题
    public Topic getTopicById(int id) {
        return topicDao.getTopicById(id);
    }

    // 独立线程执行逻辑（可扩展）
    private void runTopic(int topicId) {
        // 这里可以放话题实时处理逻辑
        System.out.println("Topic Thread started: " + topicId);
        // 示例：线程保持运行直到程序结束
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000); // 每秒循环，可扩展业务逻辑
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Topic Thread stopped: " + topicId);
    }
}
