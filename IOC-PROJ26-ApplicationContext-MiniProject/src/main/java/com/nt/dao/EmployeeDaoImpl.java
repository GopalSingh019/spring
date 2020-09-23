package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.EmployeeBo;

public class EmployeeDaoImpl implements EmployeeDao {
private DataSource ds;
private String getEmployee="SELECT ENO,ENAME,JOB,SALARY,DEPTNO FROM EMPLOYEE WHERE JOB IN(?,?,?) ORDER BY JOB";

public EmployeeDaoImpl(DataSource ds) {
	// TODO Auto-generated constructor stub
	this.ds=ds;
}
	@Override
	public List<EmployeeBo> getEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		EmployeeBo bo=null;
		List<EmployeeBo> listbo=null;
		try {
			listbo=new ArrayList();
			con=ds.getConnection();
			ps=con.prepareStatement(getEmployee);
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			rs=ps.executeQuery();
			while(rs.next()) {
				bo=new EmployeeBo();
				bo.setId(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setDept(rs.getInt(5));
				bo.setSalary(rs.getInt(4));
				listbo.add(bo);
				System.out.println(bo.getSalary());
			}
		}catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;  //exeception rethrowing
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;  //exeception rethrowing
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;  //exeception rethrowing
			}
		}
		return listbo;
	}

}
