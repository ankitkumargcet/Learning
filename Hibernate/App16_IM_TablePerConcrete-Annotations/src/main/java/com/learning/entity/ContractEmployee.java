package com.learning.entity;

import javax.persistence.*;

@Entity
@Table(name = "con_emp5")
@AttributeOverrides({ 
	@AttributeOverride(name = "eno", column = @Column(name = "ENO")),
	@AttributeOverride(name = "ename", column = @Column(name = "ENAME")) 
	})
public class ContractEmployee extends Employee {
	
	@Column(name = "PayPerHour")
	private float payPerHour;
	
	@Column(name = "ContractDuration")
	private String contractDuration;

	public float getPayPerHour() {
		return payPerHour;
	}

	public void setPayPerHour(float payPerHour) {
		this.payPerHour = payPerHour;
	}

	public String getContractDuration() {
		return contractDuration;
	}

	public void setContractDuration(String contractDuration) {
		this.contractDuration = contractDuration;
	}

}
