package com.homework4.action;

import com.homework4.bean.UserEntity;
import com.homework4.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * action -- UserAction
 */
@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
    private int userid;         //属性，id
    private String username;    //属性，账号
    private String password;    //属性，密码

    //初始化 userDAO 对象
    UserDAO userDAO = new UserDAO();

    //访问器
    public int getUserid() {
        return userid;
    }

    //访问器
    public void setUserid(int userid) {
        this.userid = userid;
    }

    //访问器
    public String getUsername() {
        return username;
    }

    //访问器
    public void setUsername(String username) {
        this.username = username;
    }

    //访问器
    public String getPassword() {
        return password;
    }

    //访问器
    public void setPassword(String password) {
        this.password = password;
    }

    //login.action
    public String login() {
        boolean flag = userDAO.login(username, password);
        if (flag)
            return "loginSuccess";
        else
            return "loginFailure";

    }

    //register.action
    public String register() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserid(userid);
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        boolean flag = userDAO.insertUser(userEntity);
        if (flag)
            return "registerSuccess";
        else
            return "registerFailure";
    }

    //updateuser.action
    public String userupdate() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserid(userid);
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        boolean flag = userDAO.updateUser(userEntity);
        if (flag)
            return "updateSuccess";
        else
            return "updateFailure";
    }

    //deleteuser.action
    public String userdelete() {
        boolean flag = userDAO.deleteUser(userid);
        if (flag)
            return "deleteSuccess";
        else
            return "deleteFailure";
    }
}
