package com.learning.test;

import com.learning.entity.Employee;
import com.learning.service.EmployeeServiceImpl;

public class Test {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setEname("Ankit");
		emp.setEsal(40000);
		emp.setEaddr("BLR");

		EmployeeServiceImpl employee = new EmployeeServiceImpl();				// change generator values in mapping file and then run application
		employee.insertEmployee(emp);											// If you find issue while inserting, truncate table or drop table and retry

	}

}
