package com.cg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Account;
import com.cg.service.AccountServiceImpl;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:4200")
public class AccountController {

	@Autowired
	AccountServiceImpl service;
	
	// url "/get"
	@GetMapping("get")
	public List<Account> getAllAccount() {
		return service.getAllAccount();
	}
	
	@PostMapping(value="add",consumes={"application/json"})
	public String addAccount(@RequestBody Account ob) {
		
		service.addAccount(ob);
		return "Record Created";
	}
	
	
	
//	accounts: Account[];
//	this.http.get<any>();
//	.subscribe(res=>this.accounts = res)
}
