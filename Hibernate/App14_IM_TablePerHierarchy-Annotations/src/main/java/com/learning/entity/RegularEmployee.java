package com.learning.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "reg_emp")
public class RegularEmployee extends Employee {
	
	@Column(name = "SALARY")
	private float salary;

	@Column(name = "BONUS")
	private int bonus;

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

}
