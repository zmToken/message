package com.message.service.user;

import com.message.dao.user.UserDao;
import com.message.entity.user.User;
import com.message.util.DateUtil;
import com.message.util.EncryptUtil;
import com.message.util.HashKit;
import org.apache.shiro.crypto.hash.SimpleHash;
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
        String salt = EncryptUtil.encodeHex(EncryptUtil.salt(8));
        user.setSalt(salt);
        user.setCreateTime(DateUtil.getCurrentTime());
        SimpleHash simpleHash = new SimpleHash(HashKit.SHA1,user.getPassword(),salt,1024);
        user.setPassword(simpleHash.toString());
        user.setNickName(user.getName());
        userDao.add(user);
    }

    public User findOne(String id){
        return userDao.findOne(id);
    }

    public User findByUserName(String name){
        return  null;
    }

}
