package com.nt.target;

import java.util.Random;

public class BankLoanMgmt {
	
	
	public final float calculateInterest(float amt,float time,float rate) {
		float interest=0f;
		System.out.println("BankLoanMgmt.calculateInterest()::compound interest");
		System.out.println(amt+" "+time+" "+rate);
		interest=amt*(float)Math.pow(1+rate/100.0,time)-amt;
		return interest;
	}
	
	public float getBalance() {
		System.out.println("BankLoanMgmt.getBalance()");
		return new Random().nextInt(100000);
	}
}
