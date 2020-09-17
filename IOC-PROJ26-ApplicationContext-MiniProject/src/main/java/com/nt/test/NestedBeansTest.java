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
		listvo=ctrl.gatherEmployee("Software", "nalla", "labour");
		((AbstractApplicationContext) pctx).close();
		((AbstractApplicationContext) cctx).close();
	}

}
