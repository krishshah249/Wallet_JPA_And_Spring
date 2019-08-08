package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.cg.entities.Account;
import com.cg.dao.AccountDAO;
import com.cg.exception.InsufficientBalanceException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService,Transaction {
	
	@Autowired
	AccountDAO a;
		
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean addAccount(Account ob) {
		// TODO Auto-generated method stub
		
		if(a.findAccount(ob.getMobile())==null) {
			a.save(ob);
			return true;
		}
		return false;
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean deleteAccount(Long mobile) {
		// TODO Auto-generated method stub
		a.delete(a.findAccount(mobile));
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public Account findAccount(long mo) {
		// TODO Auto-generated method stub
		return a.findAccount(mo);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
	
		return a.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public double withdraw(Long mobile, double amount) throws InsufficientBalanceException  {
		// TODO Auto-generated method stub
		Account ob = a.findAccount(mobile);
		if((ob.getBalance()-amount)>=1000.00)
		ob.setBalance(ob.getBalance()-amount);
		else
			throw new InsufficientBalanceException("Insufficient Balance",amount);
		a.save(ob);
		return ob.getBalance();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public double deposit(Long mobile, double amount) {
		// TODO Auto-generated method stub
		Account ob = a.findAccount(mobile);
		ob.setBalance(ob.getBalance()+amount);
		a.save(ob);
		return ob.getBalance();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean transferMoney(Long mobile1, Long mobile2, double amount) throws InsufficientBalanceException {
		// TODO Auto-generated method stub
		Account from = a.findAccount(mobile1);
		Account to = a.findAccount(mobile2);
		if((from.getBalance()-amount)>=1000.00) {
		from.setBalance(from.getBalance()-amount);
		to.setBalance(to.getBalance()+amount);
		}
		else
			throw new InsufficientBalanceException("Insufficient Balance",amount);
		a.save(from);
		a.save(to);
		return true;
	}

}
