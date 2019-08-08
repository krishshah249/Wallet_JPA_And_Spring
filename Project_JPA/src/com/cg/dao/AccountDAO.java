package com.cg.dao;
import java.util.List;


import com.cg.bean.*;
public interface AccountDAO {
	
	public boolean addAccount(Account ob);
	public boolean updateAccount(Account ob);
	public boolean deleteAccount(Account ob);
	public boolean transferMoney(Account from, Account to);
	public Account findAccount(long mo);
	public List<Account> getAllAccount();
}
