package com.csu.service;

import com.csu.dao.user.UserDao;
import com.csu.dao.user.impl.UserDaoImpl;
import com.csu.domain.user.User;

/**
 * Created by 温 睿诚 on 2016/9/14/0014.
 * 用户管理模块
 */
public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDaoImpl();
    }

    public boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return userDao.getUserByEmailAndPassword(email, password);
    }

    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }
}
