package com.learning.factory;

import com.learning.service.EmployeeService;
import com.learning.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {
	private static EmployeeService empService;

	static {
		empService = new EmployeeServiceImpl();
	}

	public static EmployeeService getEmployeeService() {
		return empService;
	}
}
