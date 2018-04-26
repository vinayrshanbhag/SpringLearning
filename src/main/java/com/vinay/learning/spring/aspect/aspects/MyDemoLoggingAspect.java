package com.vinay.learning.spring.aspect.aspects;

import com.vinay.learning.spring.aspect.model.Account;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	private Logger logger  = Logger.getLogger(getClass().getName());


	@Pointcut("execution(* *(..))")
	public void reusablePointCut(){

	}

	@Pointcut("execution( * get*(*))")
	public void forGetters(){

	}

	@Pointcut("execution( * set*())")
	public void forSetters(){

	}

	@Pointcut("reusablePointCut() && !(forGetters() || forSetters())")
	public void allMethodsExceptSettersAndGetters(){

	}

	@Pointcut("execution(* findAccounts())")
	public void findAccountMethod(){

	}
	
	//This is where we have all of our related advices
	
//	@Before("execution(public void addAccount())")
//	@Before("execution(* addAccount())")
//	@Before("execution(public void com.vinay.learning.aspect.dao.AccountDao.addAccount())")
//	@Before("execution(* *add*())")// any return type
//	@Before("execution(* addAccount(com.vinay.learning.aspect.model.Account))")// add account with Account parameter
//	@Before("execution(* addAccount(..))")// 0 to many arguments on any type
//	@Before("execution(* addAccount(*))")// one argument of any type
//	@Before("execution(* com.vinay.learning.aspect.dao.*.*(..))")
//	@Before("execution(* addAccount(com.vinay.learning.spring.aspect.model.Account,..))")//Account parameter followed by any number of arguments
//	@Before("execution(* add*(..))")// match on any parameters
//	@Before("execution(* *(..))")// Any method and any parameter


	@Before("allMethodsExceptSettersAndGetters()")
	public void beforeAddAccountAdvice() {
		logger.info("Executing beforeAccountAdvice on Add account()");
	}

	@AfterReturning(pointcut = "findAccountMethod()", returning = "result")
	public void afterReturning(List<Account> result){
		result.stream().forEach(System.out::println);
		result.add(new Account("Shruthi","Gold"));
		logger.info("Executing after returning method on AccountDao");
	}


//    Still, the exception was propogated further to the main app
	@AfterThrowing( pointcut = "findAccountMethod()", throwing ="ex")
	public void throwingAdvice(Exception ex){

		logger.info("There was the error in the find Account Method" + ex.getMessage());

	}

    @After("allMethodsExceptSettersAndGetters()")
	public void afterAdvice(){
		logger.info(" Executing after advice after every method");

	}

    @Around("allMethodsExceptSettersAndGetters()")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		long begin = System.currentTimeMillis();

		Object result = proceedingJoinPoint.proceed();

		long end = System.currentTimeMillis();

		long duration = (end -begin)/1000;

		logger.info(proceedingJoinPoint.getSignature() + "took" + duration );

		return  result;



	}







	

}
