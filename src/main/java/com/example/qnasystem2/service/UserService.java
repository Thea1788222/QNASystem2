package com.example.qnasystem2.service;

import com.example.qnasystem2.dao.UserDao;
import com.example.qnasystem2.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao = new UserDao();

    // 用户注册
    public User register(String username, String password) {
        // 可以在这里添加用户名校验、密码哈希处理
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userDao.addUser(user);
    }

    // 用户登录
    public boolean login(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    // 获取用户信息
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    //根据用户名获取用户信息
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

}
