/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao.impl;

import java.util.List;
import org.application.dao.TestDao;
import org.application.model.Test;
import org.application.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gideon
 */
public class TestDaoImplHibernate implements TestDao
{
    @Override
    public List<Test> getAllTest() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Test> tests = session.createCriteria(Test.class).list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return tests;
    }

    @Override
    public Test getTest(int idTest) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Test test = (Test) session.get(Test.class, idTest);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return test;
    }

    @Override
    public void deleteTest(int idTest) 
    {
        for(Test test : getAllTest())
        {
            if(test.getIdtest()==idTest)
            {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                session.delete(test);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public void addTest(Test test) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(test);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void updateTest(Test tBaru) 
    {
        for(Test test : getAllTest())
        {
            if(test.getIdtest()==tBaru.getIdtest())
            {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                test.setNilai(tBaru.getNilai());
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }
}
