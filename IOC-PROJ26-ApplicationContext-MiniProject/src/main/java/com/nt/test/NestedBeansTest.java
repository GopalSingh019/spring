package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVo;

public class NestedBeansTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext pctx=null;
		ApplicationContext cctx=null;
		List<EmployeeVo> listvo=null;
		MainController ctrl=null;
		
		pctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		cctx=new ClassPathXmlApplicationContext(new String[]{"com/nt/cfgs/Presentation-bean.xml"},pctx);
		
		ctrl=cctx.getBean("cntr", MainController.class);
		
		listvo=ctrl.gatherEmployee("SOFTWARE", "nalla", "labour");
		
		listvo.forEach((EmployeeVo vo)->{
			System.out.println("ID is::"+vo.getId());
			System.out.println("NAME is::"+vo.getName());
			System.out.println("DEPT is::"+vo.getDept());
			System.out.println("JOB is::"+vo.getJob());
			System.out.println("SALARY is::"+vo.getSalary());
			System.out.println("TYPE is::"+vo.getType());
			System.out.println("===============================");
		});
		
		
		((AbstractApplicationContext) pctx).close();
		((AbstractApplicationContext) cctx).close();
	}

}
