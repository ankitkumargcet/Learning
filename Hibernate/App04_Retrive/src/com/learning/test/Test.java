package com.learning.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.entity.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			config = new Configuration();
			config.configure("/com/learning/resources/myconfig.xml");
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
/*
			Employee emp = (Employee) session.get(Employee.class, 111); 					// Commented to check load() method below
			if (emp == null) {																// Return type is either null or Object
				System.out.println("Employee does not exist");								// If record not available then will return null else Object
			} else {
				System.out.println("Employee Details");
				System.out.println("------------------------");
				System.out.println("Employee Number: " + emp.getEno());
				System.out.println("Employee Name: " + emp.getEname());
				System.out.println("Employee Salary: " + emp.getEsal());
				System.out.println("Employee Address: " + emp.getEaddr());
			}
*/
			
			System.out.println("Before calling load()");
			Employee emp = (Employee) session.load(Employee.class, 555); 					// hibernate query is displayed in b/w because of lazy loading
//			System.out.println(emp);														// It will give exception as it is calling all properties from database
			System.out.println(emp.getEno());												// It will not give exception as using the local reference Key
			System.out.println("After calling load()");										// Database interaction will not happen unless properties are called
																							// note: Calling Other than primary key only will interact with database
/*
			System.out.println("Employee Details");											// No null return so will throw Exception if Record not available
			System.out.println("------------------------");
			System.out.println("Employee Number: " + emp.getEno());
			System.out.println("Employee Name: " + emp.getEname());
			System.out.println("Employee Salary: " + emp.getEsal());
			System.out.println("Employee Address: " + emp.getEaddr());
*/

		} catch (Exception e) {
			System.out.println("Retrival Failed: " + e.getMessage());
		} finally {
			session.close();
			sessionFactory.close();

		}
	}

}
