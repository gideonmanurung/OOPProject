/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao.impl;

import java.util.List;
import org.application.dao.UserDao;
import org.application.model.User;
import org.application.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gideon
 */
public class UserDaoImplHibernate implements UserDao
{

    @Override
    public List<User> getAllUser() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<User> users = session.createCriteria(User.class).list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return users;
    }

    @Override
    public User getUser(int id) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        User user = (User)session.get(User.class, id);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return user;
    }

    @Override
    public void deleteUser(User user) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.delete(user);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }
    
    @Override
    public void addUser(User user)
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }
}
