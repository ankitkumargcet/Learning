package com.learning.entity;

import javax.persistence.*;

@Entity
@Table(name = "emp5")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "ENO")
	private int eno;

	@Column(name = "ENAME")
	private String ename;

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

}
