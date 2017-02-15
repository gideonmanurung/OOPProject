/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao.impl;

import java.util.List;
import org.application.dao.ForumDao;
import org.application.model.Forum;
import org.application.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gideon
 */
public class ForumDaoImplHibernate implements ForumDao
{
    @Override
    public List<Forum> getAllForum() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Forum> forums = session.createCriteria(Forum.class).list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return forums;
    }

    @Override
    public Forum getForum(int idForum) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Forum forum = (Forum) session.get(Forum.class, idForum);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return forum;
    }

    @Override
    public void deleteForum(int idForum) 
    {
        for(Forum forum : getAllForum())
        {
            if(forum.getIdforum()==idForum)
            {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                session.delete(forum);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public void addForum(Forum forum) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(forum);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void updateForum(Forum fBaru) 
    {
        for(Forum forum : getAllForum())
        {
            if(forum.getIdforum()==fBaru.getIdforum())
            {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                forum.setDescription(fBaru.getDescription());
                forum.setTitle(fBaru.getTitle());
                forum.setTopic(fBaru.getTopic());
                session.update(forum);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }
}
