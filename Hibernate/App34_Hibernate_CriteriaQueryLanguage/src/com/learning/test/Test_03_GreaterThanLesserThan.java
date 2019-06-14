package com.learning.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class Test_03_GreaterThanLesserThan {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		// Creating Criteria for greater than value
		Criteria criteria1 = session.createCriteria(Employee.class);

		// Setting Restriction, (Be specific with the data type)
		criteria1.add(Restrictions.gt("esal", 8000f));

		// Saving Result to list
		List<Employee> list1 = criteria1.list();

		// Displaying Result
		Display.displayAll(list1);
		
		System.out.println();

		// Creating Criteria for less than value
		Criteria criteria2 = session.createCriteria(Employee.class);

		// Setting Restriction, (Be specific with the data type)
		criteria2.add(Restrictions.lt("esal", 8000f));

		// Saving Result to list
		List<Employee> list2 = criteria2.list();

		// Displaying Result
		Display.displayAll(list2);

	}

}
