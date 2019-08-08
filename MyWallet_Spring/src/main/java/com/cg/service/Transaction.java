package com.cg.service;

import com.cg.entities.Account;
import com.cg.exception.InsufficientBalanceException;

public interface Transaction extends AccountService {
	 public double withdraw(Long ob,double amount) throws InsufficientBalanceException;
	 public double deposit(Long ob,double amount);
	 public boolean transferMoney(Long from,Long to,double amount) throws InsufficientBalanceException;
	 
	 public default void printStatement(Account ob) {
		 
		 System.out.println("========================================");
		 System.out.println("Statement for Account NO.: "+ob.getAid());

		 System.out.println("Account Holder: "+ob.getAccountholder());
		 System.out.println("Balance is => "+ob.getBalance());
		 System.out.println("========================================");
		 
	 }
	 
}
