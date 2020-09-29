package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.target.BankLoanMgmt;

public class MethodReplacerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=null;
		BankLoanMgmt lmgmt=null;
		float balance=0f;
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		lmgmt=ctx.getBean("bank",BankLoanMgmt.class);
		balance=lmgmt.getBalance();
		System.out.println(balance);
		System.out.println(lmgmt.calculateInterest(100000, 2, 5));
		
		((AbstractApplicationContext)ctx).close();
	}

}
