/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao;

import java.util.List;
import org.application.model.Test;

/**
 *
 * @author Gideon
 */
public interface TestDao 
{
    public List<Test> getAllTest();
    public Test getTest(int idTest);
    public void deleteTest(int idTest);
    public void addTest(Test test);
    public void updateTest(Test test);
}
