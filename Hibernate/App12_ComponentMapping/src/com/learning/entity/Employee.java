package com.learning.entity;

public class Employee {
	private int eno;
	private String ename;
	private float esal;
	private Address eaddr;

	public Employee() {
		super();
	}

	public Employee(int eno, String ename, float esal, Address eaddr) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.esal = esal;
		this.eaddr = eaddr;
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public float getEsal() {
		return esal;
	}

	public void setEsal(float esal) {
		this.esal = esal;
	}

	public Address getEaddr() {
		return eaddr;
	}

	public void setEaddr(Address eaddr) {
		this.eaddr = eaddr;
	}

}
