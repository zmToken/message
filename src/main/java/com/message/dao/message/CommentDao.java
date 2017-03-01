package com.message.dao.message;

import com.message.dao.BaseDao;
import com.message.entity.message.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Alcott Hawk
 * @Date 2/27/2017
 */
@Repository
@Transactional
public class CommentDao implements BaseDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Comment findOne(Object arg) {
        return getSession().find(Comment.class,arg);
    }

    public List<Comment> findByMessage(Object arg) {
        String sql = "from comment c where c.messageId = ?";
        return getSession().createQuery(sql).setParameter(0,arg).getResultList();
    }

    public void delete(Object arg) {
        getSession().delete(arg);
    }

    public <T> T update(T t) {
        getSession().saveOrUpdate(t);
        return t;
    }

    public void add(Object t) {
        getSession().save(t);
    }

    private Session getSession(){
        return sessionFactory.openSession();
    }
}
