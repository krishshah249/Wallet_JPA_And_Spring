package com.cg.pl;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.cg.bean.*;
import com.cg.exception.InsufficientBalanceException;
import com.cg.service.AccountService;
import com.cg.service.Validator;
public class MyWallet {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		AccountService service= new AccountService();
		
		String choice="";
		long mobile=0l;
		String accountholder="";
		double balance=0.0;
		double amount=0.0;
		String temp="";
		Account a=null;
		Account b=null;
		Account ob=null;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		while(true) {
				System.out.println("Menu");
				System.out.println("======================================");
				System.out.println("1. Create new Account");
				System.out.println("2. Do Transaction");
				System.out.println("3. Delete Account");
				System.out.println("4. Find Account");
				System.out.println("5. Get All Account");
				System.out.println("6. Transfer Money");
				System.out.println("7. Exit");
				System.out.println("Enter your choice");
				choice= br.readLine();
				switch(choice) {

						
				case "1":	//System.out.println("Enter aid");
//							// validator for aid
//				
//							while(true) {
//							temp=br.readLine();
//							
//							if(Validator.validatedata(temp,Validator.aidpattern)== true) {
//							try {	
//							aid= Integer.parseInt(temp);
//							break;
//							}
//							catch(NumberFormatException e) {
//								
//								System.out.println("Re Enter the aid");
//							}
//							}
//							else {
//								System.out.println("ReEnter a numeric and 3 digit number");
//							}
//							}
							
							System.out.println("Enter mobile");
							// validator for mobile
							
							while(true) {
							temp=br.readLine();
							if(Validator.validatedata(temp,Validator.mobilepattern)== true) {
								try {	
									mobile= Long.parseLong(temp);
									break;
								}
								catch(NumberFormatException e) {
									
									System.out.println("Re Enter the mobile number");
								}
								}
								else {
									System.out.println("ReEnter a numeric and 10 digit number");
								}
							
							}
							//a= service.findAccount(mobile);
							//if(a!=null)
								//System.out.println("The mobile number already exists");
							//else {
							// validator for accountholder
							System.out.println("Enter accountholder");
							while(true) {
							temp=br.readLine();
							
							if(Validator.validatedata(temp,Validator.namepattern)== true) {
								try {	
									accountholder= temp;
									break;
								}
								catch(NumberFormatException e) {
									
									System.out.println("Re Enter the name");
								}
								}
								else {
									System.out.println("ReEnter a two word name");
								}
							}
							// validator for balance
							System.out.println("Enter balance");
							while(true) {
							temp=br.readLine();
							if(Validator.validatedata(temp,Validator.balancepattern)== true) {
								try {	
									balance= Double.parseDouble(temp);
									if(balance>=1000.00)
									break;
									else System.out.println("The balance must be > 1000.00\nRe-Enter balance");
								}
								catch(NumberFormatException e) {
									
									System.out.println("Re Enter the balance");
								}
								}
								else {
									System.out.println("Balance must be positive");
								}
							
							}
				 			ob= new Account(mobile,accountholder,balance);
				 			if(service.addAccount(ob)==true)
				 				System.out.println("Account Successfully Added");
				 			else
				 				System.out.println("Account Not Added");
				 			break;
							//}
				case "2":	do {
							System.out.println("Enter the mobile number");
							temp=br.readLine();
							}while(!validateMobile(temp));
							mobile=Long.parseLong(temp);
							a= service.findAccount(mobile);
							if(a==null)
								System.out.println("The mobile number does not exist");
							else {
								System.out.println("1. Deposit");
								System.out.println("2. Withdrawal");
								String choice1=br.readLine();
								
								switch(choice1) {
								
								case "1":	System.out.println("Enter the amount");
										while(true) {
											temp=br.readLine();
												if(Validator.validatedata(temp,Validator.amountpattern)== true) {
										try {	
											amount= Double.parseDouble(temp);
											break;
										}
										catch(NumberFormatException e) {
											
											System.out.println("Re Enter the amount");
										}
										}
										else {
											System.out.println("ReEnter a valid amount");
										}
									
									}
										service.deposit(a, amount);
										break;
											
								case "2":	System.out.println("Enter the amount");
											while(true) {
													temp=br.readLine();
													if(Validator.validatedata(temp,Validator.amountpattern)== true) {
								try {	
									amount= Double.parseDouble(temp);
									break;
								}
								catch(NumberFormatException e) {
									
									System.out.println("Re Enter the amount");
								}
								}
								else {
									System.out.println("ReEnter a valid amount");
								}
							
							}
									try{
										service.withdraw(a, amount);
									}
									catch(InsufficientBalanceException e) {
										System.out.println(e.getMessage());
									}
											break;
								
								default: System.out.println("Enter valid option");
								}
								break;
							}
							
							break;
				case "3":	System.out.println("Enter the mobile number of the account you want to delete");
							
				while(true) {
					temp=br.readLine();
					if(Validator.validatedata(temp,Validator.mobilepattern)== true) {
						try {	
							mobile= Long.parseLong(temp);
							break;
						}
						catch(NumberFormatException e) {
							
							System.out.println("Re Enter the mobile number");
						}
						}
						else {
							System.out.println("ReEnter a numeric and 10 digit number");
						}
					
					}
							a= service.findAccount(mobile);
							if(a==null)
								System.out.println("The mobile number does not exists");
							else {
							service.deleteAccount(service.findAccount(mobile));
							System.out.println("The account is deleted");
							}break;
				case "4":	System.out.println("Enter the mobile number");
							
				
				while(true) {
					temp=br.readLine();
					if(Validator.validatedata(temp,Validator.mobilepattern)== true) {
						try {	
							mobile= Long.parseLong(temp);
							break;
						}
						catch(NumberFormatException e) {
							
							System.out.println("Re Enter the mobile number");
						}
						}
						else {
							System.out.println("ReEnter a numeric and 10 digit number");
						}
					
					}
							a= service.findAccount(mobile);
							if(a==null)
								System.out.println("The account does not exists");
							else 
								service.printStatement(a);
							break;
				case "5":	System.out.println("The Details of the accounts are:");
							if(service.getAllAccount()==null)
								System.out.println("No Accounts found");
							else {
								List<Account> list = service.getAllAccount();
								
								for(Account o: list)
									service.printStatement(o);
							}break;
				case "6":	System.out.println("Enter the mobile no of the account from which amount is to be deducted:");
							
				while(true) {
					temp=br.readLine();
					if(Validator.validatedata(temp,Validator.mobilepattern)== true) {
						try {	
							mobile= Long.parseLong(temp);
							break;
						}
						catch(NumberFormatException e) {
							
							System.out.println("Re Enter the mobile number");
						}
						}
						else {
							System.out.println("ReEnter a numeric and 10 digit number");
						}
					
					}
					a= service.findAccount(mobile);
					if(a==null)
						System.out.println("The mobile number does not exist");
					else {
							System.out.println("Enter the mobile no of the account from which amount is to be added:");
							
							while(true) {
								temp=br.readLine();
								if(Validator.validatedata(temp,Validator.mobilepattern)== true) {
									try {	
										mobile= Long.parseLong(temp);
										break;
									}
									catch(NumberFormatException e) {
										
										System.out.println("Re Enter the mobile number");
									}
									}
									else {
										System.out.println("ReEnter a numeric and 10 digit number");
									}
								
								}
								b= service.findAccount(mobile);
								if(b==null)
									System.out.println("The mobile number does not exist");
								else {
									System.out.println("Enter the amount to be transfered");
									
									while(true) {
										temp=br.readLine();
											if(Validator.validatedata(temp,Validator.amountpattern)== true) {
									try {	
										amount= Double.parseDouble(temp);
										break;
									}
									catch(NumberFormatException e) {
										
										System.out.println("Re Enter the amount");
									}
									}
									else {
										System.out.println("ReEnter a valid amount");
									}
								
								}
									try {
									service.transferMoney(a,b,amount);
									}
									catch(InsufficientBalanceException e) {
										
										System.out.println(e.getMessage());
									}
									}
					}
							break;
				case "7":	System.exit(0);
					
				default: System.out.println("Enter Valid Option");
				}
		}
		
	}
	
	private static boolean validateMobile(String temp) {
			if(Validator.validatedata(temp,Validator.mobilepattern)== true) {
					return true;
			}
			System.out.println("ReEnter a numeric and 10 digit number");
			return false;
	}
	
}
