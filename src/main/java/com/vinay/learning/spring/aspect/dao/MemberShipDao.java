package com.vinay.learning.spring.aspect.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDao {
	
	public void addAccount() {
		System.out.println(" Calling DB operation in membership Dao");
	}

}
