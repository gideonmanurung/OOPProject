/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao.impl;

import java.util.List;
import org.application.dao.ProgressDao;
import org.application.model.Progress;
import org.application.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gideon
 */
public class ProgressDaoImplHibernate implements ProgressDao
{
    @Override
    public List<Progress> getAllProgress() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Progress> progresss = session.createCriteria(Progress.class).list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return progresss;
    }

    @Override
    public Progress getProgress(String username) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Progress progress = (Progress) session.get(Progress.class, username);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return progress;
    }

    @Override
    public void deleteProgress(String username) 
    {
        for(Progress progress : getAllProgress())
        {
            if(progress.getUsername().matches(username))
            {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                session.delete(progress);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public void addProgress(Progress progress) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(progress);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void updateProgress(Progress pBaru) 
    {
        for(Progress progress : getAllProgress())
        {
            if(progress.getUsername().matches(pBaru.getUsername()))
            {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                progress.setPersentasi(pBaru.getPersentasi());
                session.update(progress);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }
}
