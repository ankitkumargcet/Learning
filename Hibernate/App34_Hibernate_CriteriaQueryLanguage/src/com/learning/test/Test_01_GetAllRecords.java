package com.learning.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class Test_01_GetAllRecords {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		// Creating Criteria
		Criteria criteria = session.createCriteria(Employee.class);
		
		//Saving Result to list
		List<Employee> list = criteria.list();
		
		// Review Fetched Result
		Display.displayAll(list);

	}

}
