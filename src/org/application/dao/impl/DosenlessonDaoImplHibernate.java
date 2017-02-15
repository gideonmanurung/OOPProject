/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao.impl;

import java.util.List;
import org.application.dao.DosenlessonDao;
import org.application.model.Dosenlesson;
import org.application.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gideon
 */
public class DosenlessonDaoImplHibernate implements DosenlessonDao
{

    @Override
    public List<Dosenlesson> getAllDosenLesson() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Dosenlesson> dLessons = session.createCriteria(Dosenlesson.class).list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return dLessons;
    }

    @Override
    public void addDosenLesson(Dosenlesson dLesson) 
    {
    }

    @Override
    public void deleteDosenLesson(Dosenlesson dLesson) 
    {
    }

    @Override
    public Dosenlesson getDosenLesson(int id) 
    {
        Dosenlesson dLesson = null;
        return dLesson;
    }
    
}
