package com.learning.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "con_emp")
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
