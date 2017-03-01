package com.message.service.message;

import com.message.dao.message.MessageDao;
import com.message.entity.message.Message;
import com.message.system.ShiroUser;
import com.message.util.DateUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Alcott Hawk
 * @Date 2/27/2017
 */
@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    public List<Message> list(){
        return messageDao.findAll();
    }

    public Message findOne(String id){
        return messageDao.findOne(id);
    }

    public boolean create(Message message){
        message.setCreateTime(DateUtil.getCurrentTime());
        message.setAuthor(((ShiroUser) SecurityUtils.getSubject()).id);
        messageDao.add(message);
        return  true;
    }

    public boolean agree(String id){
        Message message = messageDao.findOne(id);
        if (null != message){
            message.setAgree(message.getAgree() + 1);
            messageDao.update(message);
            return true;
        }else {
            return false;
        }
    }

    public boolean disagree(String id){
        Message message = messageDao.findOne(id);
        if (null != message){
            message.setAgree(message.getAgree() - 1);
            messageDao.update(message);
            return true;
        }else {
            return false;
        }
    }

    public boolean disableShow(String id){
        Message message = messageDao.findOne(id);
        if (null != message){
            message.setShow(false);
            messageDao.update(message);
            return true;
        }else {
            return false;
        }
    }

    public boolean show(String id){
        Message message = messageDao.findOne(id);
        if (null != message){
            message.setShow(true);
            messageDao.update(message);
            return true;
        }else {
            return false;
        }
    }

    public boolean delete(String id){
        Message message = messageDao.findOne(id);
        if (null != message){
            messageDao.delete(message);
            return true;
        }else {
            return false;
        }
    }

}
