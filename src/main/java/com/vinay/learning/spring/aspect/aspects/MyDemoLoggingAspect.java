package com.vinay.learning.spring.aspect.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	
	//This is where we have all of our related advices
	
//	@Before("execution(public void addAccount())")
//	@Before("execution(* addAccount())")
//	@Before("execution(public void com.vinay.learning.aspect.dao.AccountDao.addAccount())")
//	@Before("execution(* *add*())")// any return type
//	@Before("execution(* addAccount(com.vinay.learning.aspect.model.Account))")// add account with Account parameter
//	@Before("execution(* addAccount(..))")// 0 to many arguments on any type
//	@Before("execution(* addAccount(*))")// one argument of any type
//	@Before("execution(* com.vinay.learning.aspect.dao.*.*(..))")
	@Before("execution(* addAccount(com.vinay.learning.spring.aspect.model.Account,..))")//Account parameter followed by any number of arguments
	public void beforeAddAccountAdvice() {
		System.out.println("Executing @Before advice on Add account()");
	}
	

}
