package com.cg.service;

import java.util.List;


import com.cg.entities.Account;

public interface AccountService {

	public boolean addAccount(Account ob);
	public boolean deleteAccount(Long mobile);
	public Account findAccount(long mo);
	public List<Account> getAllAccount();


}
