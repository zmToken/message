package com.message.entity.user;

import com.message.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author Alcott Hawk
 * @Date 2/22/2017
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity{

    private String name;
    private String nickName;
    private String password;
    private String salt;
    private String phone;
    private String createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
