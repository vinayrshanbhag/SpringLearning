package com.vinay.learning.spring.aspect.dao;

import com.vinay.learning.spring.aspect.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Component
public class AccountDao {

    private String accountNumber;

    private String serviceCode;

    private Logger myLogger = Logger.getLogger(getClass().getName());
	
	public void  addAccount() {
		System.out.println(getClass() + "Doing db operation to add account");
	}
	
	public void addAccount(Account account) {
		System.out.println(getClass()+ "accepting the ");
	}

	public List<Account> findAccounts() throws Exception {
		List<Account> myAccounts = new ArrayList<>();
		myAccounts.add(new Account("Vinay", "first"));
		myAccounts.add(new Account("Ramesh","Second"));
//		throw new Exception();
		return myAccounts;
	}


	public void updateAccount() {
		myLogger.info("Doing my DB work on update account");
	}


	public String getAccountNumber() {
		myLogger.info("getter called");
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		myLogger.info("Setters called...");
		this.accountNumber = accountNumber;
	}

	public String getServiceCode() {
		myLogger.info("Get service called...");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		myLogger.info("Set Service Code called");
		this.serviceCode = serviceCode;
	}
}
