package com.cg.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ACCOUNT")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="AID")
	private Integer aid;
	
	
	@Column(name="MOBILE", unique=true,nullable=false)
	private Long mobile;
	
	@Column(name="ACCOUNT_HOLDER")
	private String accountholder;
	
	@Column(name="BALANCE")
	private Double balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Account(Long mobile, String accountholder, Double balance) {
		super();
		this.mobile = mobile;
		this.accountholder = accountholder;
		this.balance = balance;
	}
	
	
	
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getAccountholder() {
		return accountholder;
	}
	public void setAccountholder(String accountholder) {
		this.accountholder = accountholder;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "Account [aid=" + aid + ", mobile=" + mobile + ", accountholder=" + accountholder + ", balance="
				+ balance + "]";
	}
	
//	public Double withdraw (Double amount) {
//		balance-=amount;
//		return balance;
//	}
	
	
	
	
}
