package com.message.dao.message;

import com.message.dao.BaseDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Alcott Hawk
 * @Date 2/27/2017
 */
@Repository
@Transactional
public class MessageDao implements BaseDao{
    public <T> T findOne(Object arg) {
        return null;
    }

    public void delete(Object arg) {

    }

    public <T> T update(T t) {
        return null;
    }

    public void add(Object t) {

    }
}
