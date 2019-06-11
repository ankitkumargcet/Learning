package com.learning.dao;

import com.learning.beans.Employee;

public interface EmployeeDAO {
	public String insertEmployee(Employee emp);

	public Employee searchEmployee(int eno);

	public String updateEmployee(Employee emp);

	public String deleteEmployee(int no);
}
