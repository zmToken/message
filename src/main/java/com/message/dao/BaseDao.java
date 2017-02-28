package com.message.dao;

/**
 * @Author Alcott Hawk
 * @Date 2/27/2017
 */
public interface BaseDao {

    public <T extends Object> T findOne(Object arg);

    public void delete(Object arg);

    public <T extends Object> T update(T t);

    public void add(Object t);

}
