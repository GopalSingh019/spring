package com.nt.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.Playervo;

public class RealTimeDITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=null;
		Scanner sc=new Scanner(System.in);
		Playervo vo=new Playervo();
		System.out.println("Enter player name");
		vo.setName(sc.next());
		System.out.println("Enter Player team");
		vo.setTeam(sc.next());
		System.out.println("Enter Auction1");
		vo.setAuction1(sc.next());
		System.out.println("Enter Auction2");
		vo.setAuction2(sc.next());
		System.out.println("Enter Auction3");
		vo.setAuction3(sc.next());
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
        MainController controller=ctx.getBean("cntl", MainController.class);
        controller.Process(vo);
        sc.close();
	}

}
