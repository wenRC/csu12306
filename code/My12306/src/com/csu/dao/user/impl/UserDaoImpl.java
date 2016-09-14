package com.csu.dao.user.impl;

import com.csu.dao.user.UserDao;
import com.csu.domain.user.User;

/**
 * Created by 温 睿诚 on 2016/9/14/0014.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public boolean insertUser(User user) {
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
