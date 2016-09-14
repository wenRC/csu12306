package com.csu.dao.user;

import com.csu.domain.user.User;

/**
 * Created by 温 睿诚 on 2016/9/14/0014.
 */
public interface UserDao {
    boolean insertUser(User user);
    User getUserByEmail(String email);
    User getUserByEmailAndPassword(String email,String password);
    boolean updateUser(User user);
}
