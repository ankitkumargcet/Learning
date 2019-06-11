package com.learning.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="con_emp7")
@AttributeOverrides({
	@AttributeOverride(name="eno",column = @Column(name="ENO")),
	@AttributeOverride(name="ename",column = @Column(name="ENAME"))
})
@PrimaryKeyJoinColumn(name="ENO") 
public class ContractEmployee extends Employee {
	@Column(name="PayPerHour")
	private float payPerHour;
	
	@Column(name="ContractDuration")
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
