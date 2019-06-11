package com.learning.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.beans.Employee;
import com.learning.dao.EmployeeDAO;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDAO dao = (EmployeeDAO) context.getBean("empDAO");

		// Commented to perform below search Operation
		Employee emp = new Employee();
		emp.setEno(333);
		emp.setEname("CCC");
		emp.setEsal(7000);
		emp.setEaddr("HYD");
		String status = dao.insertEmployee(emp);
		System.out.println(status);

		/*
		 * // Commented to perform below search Operation Employee emp =
		 * dao.searchEmployee(555); if (emp != null) {
		 * System.out.println("Employee Details");
		 * System.out.println("-------------------------");
		 * System.out.println("Employee Number : " + emp.getEno());
		 * System.out.println("Employee Name : " + emp.getEname());
		 * System.out.println("Employee Salary : " + emp.getEsal());
		 * System.out.println("Employee Address : " + emp.getEaddr()); } else {
		 * System.out.println("Employee does not exist"); }
		 */

		/*
		 * // Commented to perform below search Operation Employee emp = new Employee();
		 * emp.setEno(111); emp.setEname("aaa"); emp.setEsal(5500);
		 * emp.setEaddr("PUNE"); String status = dao.updateEmployee(emp);
		 * System.out.println(status);
		 */

		/*
		 * String status = dao.deleteEmployee(444); System.out.println(status);
		 */
	}

}
