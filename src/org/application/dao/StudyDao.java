/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao;

import java.util.List;
import org.application.model.Study;

/**
 *
 * @author Gideon
 */
public interface StudyDao 
{
    public List<Study> getAllStudy();
    public Study getStudy(int idStudy);
    public void deleteStudy(int idStudy);
    public void addStudy(Study study);
    public void updateStudy(Study study);
}
