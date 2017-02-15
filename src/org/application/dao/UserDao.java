/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao;

import java.util.List;
import org.application.model.User;

/**
 *
 * @author Gideon
 */
public interface UserDao 
{
    public List<User> getAllUser();
    public User getUser(int id);
    public void addUser(User user);
    public void deleteUser(User user);
}
