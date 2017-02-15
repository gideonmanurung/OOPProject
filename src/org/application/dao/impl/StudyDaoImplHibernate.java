/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao.impl;

import java.util.List;
import org.application.dao.StudyDao;
import org.application.model.Study;
import org.application.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gideon
 */
public class StudyDaoImplHibernate implements StudyDao
{
    @Override
    public List<Study> getAllStudy() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Study> studys = session.createCriteria(Study.class).list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return studys;
    }

    @Override
    public Study getStudy(int idStudy) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Study study = (Study) session.get(Study.class, idStudy);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return study;
    }

    @Override
    public void deleteStudy(int idStudy) 
    {
        for(Study study : getAllStudy())
        {
            if(study.getIdstudy()==idStudy)
            {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                session.delete(study);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public void addStudy(Study study) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(study);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void updateStudy(Study sBaru) 
    {
        for(Study study : getAllStudy())
        {
            if(study.getIdstudy()==sBaru.getIdstudy())
            {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }
}
