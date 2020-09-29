package com.nt.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class BankInterestReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("BankInterestReplacer.reimplement()");
		
		float pamt=(float)args[0];
		float time=(float)args[1];
		float rate=(float)args[2];
		
		
		return (pamt*time*rate/100.0f);
	}

}
