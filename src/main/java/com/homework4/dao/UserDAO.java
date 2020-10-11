package com.homework4.dao;

import com.homework4.bean.UserEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * DAO -- UserDAO
 */
public class UserDAO {
    //hibernate 核心配置文件
    public static String hiFileStr = "hibernate.cfg.xml";

    //登录
    public boolean login(String username, String password) {
        boolean flag = false;
        Configuration configuration = new Configuration();
        configuration.configure(hiFileStr);
        try (SessionFactory sessionFactory = configuration.buildSessionFactory(); Session session = sessionFactory.openSession()) {

            String hql = "from com.homework4.bean.UserEntity user where user.username = :username and user.password = :password";
            Query q = session.createQuery(hql);
            q.setParameter("username", username);
            q.setParameter("password", password);

            UserEntity userEntity = (UserEntity) q.uniqueResult();
            if (userEntity != null) {
                flag = true;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //插入数据
    public boolean insertUser(UserEntity para_userEntity) {
        Configuration configuration = new Configuration();
        configuration.configure(hiFileStr);
        Transaction transaction = null;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory(); Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(para_userEntity);
            transaction.commit();
            System.out.println("==== 提交 “插入” 请求 ====");
            return true;
        } catch (HibernateException e) {
            System.out.println("==== “插入” 请求异常 ====");
            e.printStackTrace();
            return false;
        }
    }

    //查询数据表全部数据到 list
    public List<UserEntity> selectUser() {
        Configuration configuration = new Configuration();
        configuration.configure(hiFileStr);
        Transaction transaction = null;
        List<UserEntity> list = null;
        try {
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "from UserEntity";
            Query query = session.createQuery(hql);
            list = query.list();
            System.out.println("==== “查询全部信息” 请求成功 ====");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("==== “查询全部信息” 请求异常 ====");
        }
        return list;
    }

    //修改数据
    public boolean updateUser(UserEntity para_userEntity) {
        Configuration configuration = new Configuration();
        configuration.configure(hiFileStr);
        Transaction transaction = null;
        try {
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            UserEntity userEntity = session.load(UserEntity.class, para_userEntity.getUserid());
            userEntity.setUsername(para_userEntity.getUsername());
            userEntity.setPassword(para_userEntity.getPassword());
            session.update(userEntity);
            transaction.commit();
            System.out.println("==== 提交 “更新” 请求 ====");
            return true;
        } catch (HibernateException e) {
            System.out.println("==== “更新” 请求异常 ====");
            e.printStackTrace();
            return false;
        }
    }

    //删除数据
    public boolean deleteUser(int para_userid) {
        Configuration configuration = new Configuration();
        configuration.configure(hiFileStr);
        Transaction transaction = null;
        try {
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            UserEntity userEntity = (UserEntity) session.get(UserEntity.class, para_userid);
            session.delete(userEntity);
            transaction.commit();
            System.out.println("==== 提交 “删除” 请求 ====");
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("==== “删除” 请求异常 ====");
            return false;
        }
    }
}
