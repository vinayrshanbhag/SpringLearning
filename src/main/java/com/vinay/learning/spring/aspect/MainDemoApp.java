package com.vinay.learning.spring.aspect;

import com.vinay.learning.spring.aspect.config.DemoConfig;
import com.vinay.learning.spring.aspect.dao.AccountDao;
import com.vinay.learning.spring.aspect.dao.MemberShipDao;
import com.vinay.learning.spring.aspect.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;


public class MainDemoApp {

	private static  Logger myLogger = Logger.getLogger(MainDemoApp.class.getName());

	public static void main(String[] args) throws Exception {


		
//		Read spring config java class
		AnnotationConfigApplicationContext context =
				      new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao theAccountDao = context.getBean(AccountDao.class);

        List<Account> accounts = theAccountDao.findAccounts();

		myLogger.info("Size of the accounts"+accounts.size());


//		theAccountDao.setAccountNumber("1234567");
//		theAccountDao.getAccountNumber();
//
//		theAccountDao.addAccount();
//		theAccountDao.addAccount(new Account());
//
////		call it again
//
//
//		MemberShipDao membershipDao = context.getBean(MemberShipDao.class);
//		membershipDao.addAccount();
		
		context.close();
		
		
	}

}
