package com.message.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @Author Alcott Hawk
 * @Date 2/27/2017
 */
@MappedSuperclass
public class BaseEntity {

    protected String id;

    @Id
    @GenericGenerator(name="uuidGenerator", strategy="uuid2")
    @GeneratedValue(generator = "uuidGenerator")
    @Column(name = "id", nullable = false, unique = true, length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
