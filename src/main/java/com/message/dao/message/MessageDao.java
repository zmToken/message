package com.message.dao.message;

import com.message.dao.BaseDao;
import com.message.entity.message.Message;
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
public class MessageDao implements BaseDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Message findOne(Object id) {
        return getSession().find(Message.class,id);
    }

    public List<Message> findAll(){
        return getSession().createNativeQuery("select * from message").getResultList();
    }

    public List<Message> findAll(int pageSize, int pageNum){
        String sql = "select * from message";
        return getSession().createQuery(sql).setFirstResult(pageNum).setMaxResults(pageSize).getResultList();
    }

    public void delete(Object arg) {
        getSession().delete(arg);
    }

    public <T> T update(T t) {
        getSession().saveOrUpdate(t);
        return t;
    }

    public <T> T update(String id, T t) {
        getSession().saveOrUpdate(id, t);
        return t;
    }

    public void add(Object t) {
        getSession().save(t);
    }

    private Session getSession(){
        return sessionFactory.openSession();
    }
}
