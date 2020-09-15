package com.nt.controller;

import com.nt.dto.Playerdto;
import com.nt.service.Playerservice;
import com.nt.vo.Playervo;

public class MainController {
	private Playerservice ps;

	public MainController(Playerservice ps) {
		this.ps = ps;
	}
    public void Process(Playervo vo) {
    	Playerdto dto=new Playerdto();
    	dto.setName(vo.getName());
    	dto.setTeam(vo.getTeam());
    	dto.setAuction1(Integer.parseInt(vo.getAuction1()));
    	dto.setAuction2(Integer.parseInt(vo.getAuction2()));
    	dto.setAuction3(Integer.parseInt(vo.getAuction3()));
    	try {
			System.out.println(ps.CalculatePrice(dto));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Internal Problem");
			e.printStackTrace();
		}
    }
}
