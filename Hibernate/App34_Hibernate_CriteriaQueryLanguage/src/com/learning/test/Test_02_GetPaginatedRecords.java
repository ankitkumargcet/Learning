package com.learning.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class Test_02_GetPaginatedRecords {
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		// Creating Criteria
		Criteria criteria = session.createCriteria(Employee.class);
		
		// It will set the first value as 2 with indexing starts from 0
		criteria.setFirstResult(2);
		
		// It will fetch next 4 values from new first value i.e-2
		criteria.setMaxResults(4);

		// Saving paginated result to list
		List<Employee> list = criteria.list();

		// Review Fetched Result
		Display.displayAll(list);

	}
}
