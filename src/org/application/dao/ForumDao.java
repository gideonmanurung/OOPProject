/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao;

import java.util.List;
import org.application.model.Forum;

/**
 *
 * @author Gideon
 */
public interface ForumDao 
{
    public List<Forum> getAllForum();
    public Forum getForum(int idForum);
    public void deleteForum(int idForum);
    public void addForum(Forum forum);
    public void updateForum(Forum forum);
}
