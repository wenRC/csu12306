package com.csu.dao.user;

import com.csu.dao.user.impl.UserDaoImpl;
import com.csu.domain.user.User;

/**
 * Created by 温 睿诚 on 2016/9/17/0017.
 */
public class TestUserDao {
    public static void main(String[] args){
        UserDao userDao=new UserDaoImpl();
        //测试通过
        //insert
//        User user=new User();
//        user.setUserid(2);
//        user.setEmail("1@qq.com");
//        user.setPassword("1");
//        user.setUsername("tset");
//        user.setId("111");
//        user.setPhone("123123");
//        System.out.println(userDao.insertUser(user));
        //get user by email
//        System.out.println(userDao.getUserByEmail("1@qq.com").getUsername());
        //get user by email and password
//        System.out.println(userDao.getUserByEmailAndPassword("1@qq.com","1").getPhone());
        //update
//        User user=userDao.getUserByEmailAndPassword("1@qq.com","1");
//        user.setUsername("test");
//        user.setEmail("0@qq.com");
//        user.setPassword("0");
//        user.setPhone("13000000000");
//        System.out.println(userDao.updateUser(user));

    }
}
