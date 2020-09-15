package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.Playerbo;

public class PlayerdaoImpl implements Playerdao {
	private final String query = "INSERT INTO IPL VALUES(?,?,?,IPL_SEQ.NEXTVAL)";
	private DataSource ds;

	public PlayerdaoImpl(DataSource ds) {
		this.ds = ds;
	}
	@Override
	public int insert(Playerbo bo)throws Exception{
		Connection con=null;
		PreparedStatement ps=null;
		con=ds.getConnection();
		ps=con.prepareStatement(query);
		ps.setString(1, bo.getName());
		ps.setString(2, bo.getTeam());
		ps.setInt(3, bo.getSellingPrice());
		return ps.executeUpdate();
		
	}
}
