package com.vinay.learning.spring.aspect.dao;

import com.vinay.learning.spring.aspect.model.Account;
import org.springframework.stereotype.Component;


@Component
public class AccountDao {
	
	public void  addAccount() {
		System.out.println(getClass() + "Doing db operation to add account");
	}
	
	public void addAccount(Account account) {
		System.out.println(getClass()+ "accepting the ");
	}
	
	public void updateAccount() {
		System.out.println("Doing my DB work on update account");
	}
	
	

}
