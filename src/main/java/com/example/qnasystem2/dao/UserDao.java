package com.example.qnasystem2.dao;

import com.example.qnasystem2.model.User;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collection;

public class UserDao {

    // 模拟数据库存储
    private static ConcurrentHashMap<Integer, User> userDB = new ConcurrentHashMap<>();
    private static int idCounter = 1;

    // 添加用户
    public User addUser(User user) {
        user.setId(idCounter++);
        userDB.put(user.getId(), user);
        return user;
    }

    // 根据ID查询用户
    public User getUserById(int id) {
        return userDB.get(id);
    }

    // 根据用户名查询用户
    public User getUserByUsername(String username) {
        for (User u : userDB.values()) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    // 更新用户信息
    public void updateUser(User user) {
        userDB.put(user.getId(), user);
    }

    // 删除用户
    public void deleteUser(int id) {
        userDB.remove(id);
    }

    // 获取所有用户
    public Collection<User> getAllUsers() {
        return userDB.values();
    }
}
