package com.learning.test;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class Test_05_AggregationFunctions {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		TypedQuery<Employee> query = null;
		List<Employee> list = null;

		// Total Salary of all employees
		query = session.createQuery("select sum(esal) from Employee");
		list = query.getResultList();
		System.out.println("All Employees Salary: " + list.get(0));
		System.out.println();

		// Maximum Salary of Employee
		query = session.createQuery("select max(esal) from Employee");
		list = query.getResultList();
		System.out.println("Maximum Employee Salary: " + list.get(0));
		System.out.println();

		// Minimum Salary of Employee
		query = session.createQuery("select min(esal) from Employee");
		list = query.getResultList();
		System.out.println("Minimum Employee Salary: " + list.get(0));
		System.out.println();

		// No of Employees
		query = session.createQuery("select count(eno) from Employee");
		list = query.getResultList();
		System.out.println("No of Employees: " + list.get(0));
		System.out.println();

		// Average Salary of all Employees
		query = session.createQuery("select avg(esal) from Employee");
		list = query.getResultList();
		System.out.println("Average Salary: " + list.get(0));
		System.out.println();

	}

}
