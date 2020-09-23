package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import com.nt.dto.EmployeeDto;
import com.nt.service.EmployeeMgmtService;
import com.nt.vo.EmployeeVo;

public class MainController {
	private EmployeeMgmtService service;
	
	public MainController(EmployeeMgmtService service) {
		// TODO Auto-generated constructor stub
		this.service=service;
	}
	
	public List<EmployeeVo> gatherEmployee(String desg1,String desg2,String desg3){
		EmployeeVo vo=null;
		List<EmployeeDto> listdto=null;
		List<EmployeeVo> listvo=null;
		try {
			listdto=service.fetchEmployee(desg1, desg2, desg3);
			listvo=new ArrayList<EmployeeVo>();
			for(EmployeeDto dto:listdto)
			{
			     vo=new EmployeeVo();
			     vo.setId(String.valueOf(dto.getId()));
			     vo.setName(dto.getName());
			     vo.setJob(dto.getJob());
			     vo.setDept(String.valueOf(dto.getDept()));
			     vo.setSalary(String.valueOf(dto.getSalary()));
			     vo.setType(dto.getType());
			     listvo.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return listvo;
	}
}

