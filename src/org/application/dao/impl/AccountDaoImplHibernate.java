/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.dao.impl;

import java.util.List;
import org.application.dao.AccountDao;
import org.application.model.Account;
import org.application.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gideon
 */
public class AccountDaoImplHibernate implements AccountDao
{

    @Override
    public List<Account> getAllAccount() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Account> accounts = session.createCriteria(Account.class).list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return accounts;
    }

    @Override
    public Account getAccount(String username) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Account account = (Account) session.get(Account.class, username);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return account;
    }

    @Override
    public void deleteAccount(String username) 
    {
        for(Account account : getAllAccount())
        {
            if(account.getUsername().matches(username))
            {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                session.delete(account);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public void addAccount(Account account) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(account);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void updateAccount(Account aBaru) 
    {
        for(Account account : getAllAccount())
        {
            if(account.getUsername().matches(aBaru.getUsername()))
            {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                account.setNama(aBaru.getNama());
                account.setAlamat(aBaru.getAlamat());
                account.setPassword(aBaru.getPassword());
                account.setRole(aBaru.getRole());
                session.update(account);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }
}
