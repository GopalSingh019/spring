package com.nt.service;

import com.nt.bo.Playerbo;
import com.nt.dao.Playerdao;
import com.nt.dto.Playerdto;

public class PlayerserviceImpl implements Playerservice {
    private Playerdao dao;
    
	public PlayerserviceImpl(Playerdao dao) {
		this.dao = dao;
	}

	@Override
	public String CalculatePrice(Playerdto dto) throws Exception {
		// TODO Auto-generated method stub
		Playerbo bo=new Playerbo();
		bo.setName(dto.getName());
		bo.setTeam(dto.getTeam());
		int max=Math.max(dto.getAuction1(), Math.max(dto.getAuction2(), dto.getAuction3()));
		bo.setSellingPrice(max);
		int k=dao.insert(bo);
		if(k>0)
			return "Update Successful";
		else
			return "Update Fail";
	}

}
