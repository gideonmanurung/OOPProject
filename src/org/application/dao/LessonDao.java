/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao;

import java.util.List;
import org.application.model.Lesson;

/**
 *
 * @author Gideon
 */
public interface LessonDao 
{
    public List<Lesson> getAllLesson();
    public Lesson getLesson(int idLesson);
    public void deleteLesson(int idLesson);
    public void addLesson(Lesson lesson);
    public void updateLesson(Lesson lesson);
}
