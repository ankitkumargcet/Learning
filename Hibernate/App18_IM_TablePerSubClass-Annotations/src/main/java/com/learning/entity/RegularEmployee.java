package com.learning.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "reg_emp7")
@AttributeOverrides({ 
	@AttributeOverride(name = "eno", column = @Column(name = "ENO")),
	@AttributeOverride(name = "ename", column = @Column(name = "ENAME")) 
})
@PrimaryKeyJoinColumn(name="ENO") 
public class RegularEmployee extends Employee {
	
	@Column(name="SALARY")
	private float salary;
	
	@Column(name="BONUS")
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
