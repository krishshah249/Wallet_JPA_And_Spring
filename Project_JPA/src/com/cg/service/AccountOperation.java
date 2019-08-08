package com.cg.service;

import java.util.List;


import com.cg.bean.Account;

public interface AccountOperation {

	public boolean addAccount(Account ob);
	public boolean deleteAccount(Account ob);
	public Account findAccount(long mo);
	public List<Account> getAllAccount();


}
