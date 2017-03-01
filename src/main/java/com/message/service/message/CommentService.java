package com.message.service.message;

import com.message.dao.message.CommentDao;
import com.message.entity.message.Comment;
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
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public Comment findOne(String id){
        return commentDao.findOne(id);
    }

    public List<Comment> list(String id){
        return commentDao.findByMessage(id);
    }

    public boolean create(Comment comment){
        comment.setPublishTime(DateUtil.getCurrentTime());
        comment.setUserId(((ShiroUser)SecurityUtils.getSubject()).id);
        commentDao.add(comment);
        return true;
    }

    public boolean agree(String id){
        Comment comment = commentDao.findOne(id);
        if (null != comment){
            comment.setAgree(comment.getAgree() + 1);
            commentDao.update(comment);
            return true;
        }else {
            return false;
        }
    }

    public boolean disagree(String id){
        Comment comment = commentDao.findOne(id);
        if (null != comment){
            comment.setAgree(comment.getAgree() - 1);
            commentDao.update(comment);
            return true;
        }else {
            return false;
        }
    }

    public boolean disableShow(String id){
        Comment comment = commentDao.findOne(id);
        if (null != comment){
            comment.setShow(false);
            commentDao.update(comment);
            return true;
        }else {
            return false;
        }
    }

    public boolean show(String id){
        Comment comment = commentDao.findOne(id);
        if (null != comment){
            comment.setShow(true);
            commentDao.update(comment);
            return true;
        }else {
            return false;
        }
    }

    public boolean delete(String id){
        Comment comment = commentDao.findOne(id);
        if (null != comment){
            commentDao.delete(comment);
            return true;
        }else {
            return false;
        }
    }

}
