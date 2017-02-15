/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao;

import java.util.List;
import org.application.model.Progress;

/**
 *
 * @author Gideon
 */
public interface ProgressDao 
{
    public List<Progress> getAllProgress();
    public Progress getProgress(String username);
    public void deleteProgress(String username);
    public void addProgress(Progress progress);
    public void updateProgress(Progress progress);
}
