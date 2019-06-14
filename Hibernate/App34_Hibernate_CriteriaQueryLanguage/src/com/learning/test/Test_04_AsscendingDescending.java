package com.learning.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class Test_04_AsscendingDescending {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		// Creating Criteria
		Criteria criteria1 = session.createCriteria(Employee.class);

		// Setting Order Ascending
		criteria1.addOrder(Order.asc("esal"));

		// Saving Result to list
		List<Employee> list1 = criteria1.list();

		// Displaying Result
		Display.displayAll(list1);
		
		System.out.println();

		// Creating Criteria
		Criteria criteria2 = session.createCriteria(Employee.class);

		// Setting Order Descending
		criteria2.addOrder(Order.desc("esal"));

		// Saving Result to list
		List<Employee> list2 = criteria2.list();

		// Displaying Result
		Display.displayAll(list2);

	}

}
