package com.cg.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entities.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, Integer> {

	@Query("SELECT a FROM Account a where a.mobile=?1")
	Account findAccount(Long mobile);


}
