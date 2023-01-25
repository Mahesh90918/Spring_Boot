package com.example.model;

public class Employee {
	private int eid;
	private String ename;
	private double esalary;
	private String email;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, String ename, double esalary, String email) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esalary = esalary;
		this.email = email;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getEsalary() {
		return esalary;
	}

	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + ", email=" + email + "]";
	}
}
