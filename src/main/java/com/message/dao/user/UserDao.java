package com.message.dao.user;

import com.message.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Alcott Hawk
 * @Date 2/22/2017
 */
@Repository
@Transactional
public class UserDao implements BaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    public <T> T findOne(Object arg) {
        return (T) sessionFactory.getCurrentSession().createQuery("from user u where u.id = ?").setParameter(0,arg).uniqueResult();
    }

    public void delete(Object arg) {

    }

    public <T> T update(T t) {
        return null;
    }

    public void add(Object t) {
        Session session = sessionFactory.getCurrentSession();
        session.save(t);
    }
}
