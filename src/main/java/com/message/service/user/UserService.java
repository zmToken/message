package com.message.service.user;

import com.message.dao.user.UserDao;
import com.message.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Alcott Hawk
 * @Date 2/22/2017
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User delete(String id){
        return userDao.findOne(id);
    }

    public void create(User user){
        userDao.add(user);
    }

    public User findOne(String id){
        return userDao.findOne(id);
    }

    public User findByUserName(String name){
        return  null;
    }

}
