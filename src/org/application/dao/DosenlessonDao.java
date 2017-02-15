/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao;

import java.util.List;
import org.application.model.Dosenlesson;

/**
 *
 * @author Gideon
 */
public interface DosenlessonDao 
{
    public List<Dosenlesson> getAllDosenLesson();
    public void addDosenLesson(Dosenlesson dLesson);
    public void deleteDosenLesson(Dosenlesson dLesson);
    public Dosenlesson getDosenLesson(int id);
}
