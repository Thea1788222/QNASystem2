package com.example.qnasystem2.controller;

import com.example.qnasystem2.service.UserService;
import com.example.qnasystem2.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String doGet() {
        // 示例：显示用户信息或跳转登录页
        return "login";
    }

    @PostMapping
    public String doPost(@RequestParam String action, 
                         @RequestParam(required = false) String username, 
                         @RequestParam(required = false) String password,
                         @RequestParam(required = false) String captchaInput,
                         HttpServletRequest req, HttpSession session) {

        if ("login".equals(action)) {
            String captchaSession = (String) session.getAttribute("captcha");

            if (captchaSession == null || !captchaSession.equalsIgnoreCase(captchaInput)) {
                req.setAttribute("error", "验证码错误");
                return "login";
            }

            boolean success = userService.login(username, password);
            if (success) {
                User user = userService.getUserByUsername(username);
                int userid = user.getId();
                session.setAttribute("username", username);
                session.setAttribute("userid", userid);
                return "redirect:/topic";
            } else {
                req.setAttribute("error", "用户名或密码错误");
                return "login";
            }

        } else if ("register".equals(action)) {
            User user = userService.register(username, password);
            if (user != null) {
                return "redirect:/jsp/login.jsp";
            } else {
                req.setAttribute("error", "注册失败");
                return "register";
            }
        }
        return "login";
    }
}
