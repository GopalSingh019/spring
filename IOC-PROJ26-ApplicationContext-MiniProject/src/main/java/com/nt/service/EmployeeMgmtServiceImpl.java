package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBo;
import com.nt.dao.EmployeeDao;
import com.nt.dto.EmployeeDto;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	private EmployeeDao dao;

	public EmployeeMgmtServiceImpl(EmployeeDao dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}

	@Override
	public List<EmployeeDto> fetchEmployee(String desg1, String desg2, String desg3) throws Exception {
		// TODO Auto-generated method stub
		EmployeeDto dto=null;
		List<EmployeeDto> listDto=null;
		List<EmployeeBo> listbo=null;
		try {
		listDto=new ArrayList();
		listbo=dao.getEmployeeByDesg(desg1, desg2, desg3);
		for(EmployeeBo bo:listbo) {
			dto=new EmployeeDto();
			if(bo.getJob().equalsIgnoreCase("SOFTWARE"))
				dto.setType("premium");
			else
				dto.setType("non-premium");
			BeanUtils.copyProperties(bo,dto);
			listDto.add(dto);
		}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listDto;
	}

}
