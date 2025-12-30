package com.example.qnasystem2.controller;

import com.example.qnasystem2.model.Topic;
import com.example.qnasystem2.service.TopicService;
import com.example.qnasystem2.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.Collection;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;
    
    @Autowired
    private UserService userService;

    @GetMapping
    public String doGet(Model model) {
        // 获取所有话题并显示
        Collection<Topic> topics = topicService.getAllTopics();
        model.addAttribute("topics", topics);
        return "topicList";
    }

    @PostMapping
    public String doPost(@RequestParam String action, 
                         @RequestParam(required = false) String title, 
                         @RequestParam(required = false) String content, 
                         HttpSession session) {

        if ("create".equals(action)) {
            Integer userId = (Integer) session.getAttribute("userid");
            String username = (String) session.getAttribute("username");

            //校验是否登录
            if (userId == null || username == null) {
                return "redirect:/user?action=login";
            }

            topicService.createTopic(title, content, userId, username);

            return "redirect:/topic";
        }
        return "redirect:/topic";
    }
}
