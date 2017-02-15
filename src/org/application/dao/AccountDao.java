/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao;

import java.util.List;
import org.application.model.Account;

/**
 *
 * @author Gideon
 */
public interface AccountDao 
{
    public List<Account> getAllAccount();
    public Account getAccount(String username);
    public void deleteAccount(String username);
    public void addAccount(Account account);
    public void updateAccount(Account account);
}
