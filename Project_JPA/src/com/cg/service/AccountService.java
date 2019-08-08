package com.cg.service;

import java.util.List;
import com.cg.bean.Account;
import com.cg.dao.AccountDAOImpl;
import com.cg.exception.InsufficientBalanceException;

public class AccountService implements Transaction {
	
	AccountDAOImpl a= new AccountDAOImpl();
		
	@Override
	public boolean addAccount(Account ob) {
		// TODO Auto-generated method stub
		if(a.findAccount(ob.getMobile())==null) {
			a.addAccount(ob);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAccount(Account ob) {
		// TODO Auto-generated method stub
		a.deleteAccount(ob);
		return true;
	}

	@Override
	public Account findAccount(long mo) {
		// TODO Auto-generated method stub
		return a.findAccount(mo);
	}

	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
	
		return a.getAllAccount();
	}

	@Override
	public double withdraw(Account ob, double amount) throws InsufficientBalanceException  {
		// TODO Auto-generated method stub
		if((ob.getBalance()-amount)>=1000.00)
		ob.setBalance(ob.getBalance()-amount);
		else
			throw new InsufficientBalanceException("Insufficient Balance",amount);
		a.updateAccount(ob);
		return ob.getBalance();
	}

	@Override
	public double deposit(Account ob, double amount) {
		// TODO Auto-generated method stub
		ob.setBalance(ob.getBalance()+amount);
		a.updateAccount(ob);
		return ob.getBalance();
	}

	@Override
	public boolean transferMoney(Account from, Account to, double amount) throws InsufficientBalanceException {
		// TODO Auto-generated method stub
		if((from.getBalance()-amount)>=1000.00) {
		from.setBalance(from.getBalance()-amount);
		to.setBalance(to.getBalance()+amount);
		}
		else
			throw new InsufficientBalanceException("Insufficient Balance",amount);
		
		return a.transferMoney(from, to);
	}

}
