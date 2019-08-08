package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.cg.DBUtil.Db;
import com.cg.bean.Account;

public class AccountDAOImpl implements AccountDAO {
	
	private EntityManager em;
	private Db db;
	
	public AccountDAOImpl() {
		
		db= new Db();
		em=db.getManager();
		
	}

	@Override
	public boolean addAccount(Account ob) {

		em.getTransaction().begin();
		em.persist(ob);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public boolean updateAccount(Account ob) {
		// TODO Auto-generated method stub
		
		em.getTransaction().begin();
		em.merge(ob);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteAccount(Account ob) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.remove(ob);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public boolean transferMoney(Account from, Account to) {
		// TODO Auto-generated method stub
		
		em.getTransaction().begin();
		em.merge(from);
		em.merge(to);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public Account findAccount(long mo) {
		// TODO Auto-generated method stub
		
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a where a.mobile="+mo,Account.class);
		if(query.getResultList().size()==0)
			return null;
		else
			return query.getSingleResult();
	}

	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		
		TypedQuery<Account> query= em.createQuery("SELECT a FROM Account a", Account.class);
		return query.getResultList();
	}

	



}
