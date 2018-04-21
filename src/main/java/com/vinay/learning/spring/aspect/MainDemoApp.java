package com.vinay.learning.spring.aspect;

import com.vinay.learning.spring.aspect.config.DemoConfig;
import com.vinay.learning.spring.aspect.dao.AccountDao;
import com.vinay.learning.spring.aspect.dao.MemberShipDao;
import com.vinay.learning.spring.aspect.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class MainDemoApp {
	
	public static void main(String[] args) {
		
//		Read spring config java class
		AnnotationConfigApplicationContext context =
				      new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao theAccountDao = context.getBean(AccountDao.class);
		
		theAccountDao.addAccount();
		theAccountDao.addAccount(new Account());
		
//		call it again
		
		
		MemberShipDao membershipDao = context.getBean(MemberShipDao.class);
		membershipDao.addAccount();
		
		context.close();
		
		
	}

}
