package com.example.qnasystem2.controller;

import com.example.qnasystem2.service.ReplyService;
import com.example.qnasystem2.model.Reply;

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
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @GetMapping
    public String doGet(@RequestParam int topicid, Model model) {
        // 查看某个话题的所有回复
        Collection<Reply> replies = replyService.getRepliesByTopicId(topicid);
        model.addAttribute("replies", replies);
        model.addAttribute("topicid", topicid);
        return "replyList";
    }

    @PostMapping
    public String doPost(@RequestParam String action, 
                         @RequestParam(required = false) int topicid, 
                         @RequestParam(required = false) String content, 
                         HttpSession session) {

        if ("add".equals(action)) {
            Integer userid = (Integer) session.getAttribute("userid");
            String username = (String) session.getAttribute("username");

            if (userid == null || username == null) {
                return "redirect:/user?action=login";
            }

            replyService.addReply(topicid, userid, content);
            return "redirect:/reply?topicid=" + topicid;
        }
        return "redirect:/topic";
    }
}
