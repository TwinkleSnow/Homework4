package com.homework4.bean;

import javax.persistence.*;
import java.util.Objects;

/**
 * bean -- UserEntity
 */
@Entity
@Table(name = "user", schema = "homework", catalog = "")
public class UserEntity {

    private int userid;         //属性，id
    private String username;    //属性，账号
    private String password;    //属性，密码

    //构造
    public UserEntity() {
        //
    }

    //重载构造
    public UserEntity(int para_userid, String para_username, String para_password) {
        this.userid = para_userid;
        this.username = para_username;
        this.password = para_password;
    }

    //访问器
    @Id
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    //访问器
    public void setUserid(int userid) {
        this.userid = userid;
    }

    //访问器
    @Basic
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    //访问器
    public void setUsername(String username) {
        this.username = username;
    }

    //访问器
    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    //访问器
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userid == that.userid &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, username, password);
    }
}
