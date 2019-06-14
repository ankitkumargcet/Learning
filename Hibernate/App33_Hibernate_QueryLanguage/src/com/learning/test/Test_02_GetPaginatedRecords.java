package com.learning.test;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class Test_02_GetPaginatedRecords {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		TypedQuery<Employee> query = session.createQuery("from Employee");
		
		// It will set the first value as 2 with indexing starts from 0
		query.setFirstResult(2);
		
		// It will fetch next 4 values from new first value i.e-2
		query.setMaxResults(4);
		
		//Saving paginated result to list
		List<Employee> list = query.getResultList();

		
		// Review Fetched Result
		Display.displayAll(list);

	}
}
