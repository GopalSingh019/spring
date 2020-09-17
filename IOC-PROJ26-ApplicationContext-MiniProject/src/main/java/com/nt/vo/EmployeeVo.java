package com.nt.vo;

import java.io.Serializable;

public class EmployeeVo implements Serializable {
	private String id;
	private String name;
	private String job;
	private String dept;
	private String salary;
	private String type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "EmployeeVo [id=" + id + ", name=" + name + ", job=" + job + ", dept=" + dept + ", salary=" + salary
				+ ", type=" + type + "]";
	}
	
	
}
