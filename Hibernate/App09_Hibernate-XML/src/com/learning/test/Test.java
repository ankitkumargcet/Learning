package com.learning.test;

import com.learning.entity.Employee;
import com.learning.service.EmployeeServiceImpl;

public class Test {

	public static void main(String[] args) {
		Employee employee1 = new Employee();
		employee1.setEno(777);
		employee1.setEname("GGG");
		employee1.setEsal(12000);
		employee1.setEaddr("HYD");

		String status = new EmployeeServiceImpl().insertEmployee(employee1);
		System.out.println("Save Status: " + status);

	}

}
