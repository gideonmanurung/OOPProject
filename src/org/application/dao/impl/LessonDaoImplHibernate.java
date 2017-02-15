/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao.impl;

import java.util.List;
import org.application.dao.LessonDao;
import org.application.model.Lesson;
import org.application.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gideon
 */
public class LessonDaoImplHibernate implements LessonDao
{
    @Override
    public List<Lesson> getAllLesson() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Lesson> lessons = session.createCriteria(Lesson.class).list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return lessons;
    }

    @Override
    public Lesson getLesson(int idLesson) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Lesson lesson = (Lesson) session.get(Lesson.class, idLesson);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return lesson;
    }

    @Override
    public void deleteLesson(int idLesson) 
    {
        for(Lesson lesson : getAllLesson())
        {
            if(lesson.getIdlesson()==idLesson)
            {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                session.delete(lesson);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public void addLesson(Lesson lesson) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(lesson);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void updateLesson(Lesson lBaru) 
    {
        for(Lesson lesson : getAllLesson())
        {
            if(lesson.getIdlesson()==lBaru.getIdlesson())
            {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                lesson.setTitle(lBaru.getTitle());
                lesson.setTopic(lBaru.getTopic());
                session.update(lesson);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }
    
    
}
