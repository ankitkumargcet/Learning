package com.learning.test;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class Test_01_GetAllRecords {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		// Getting all records from database
		TypedQuery<Employee> query = session.createQuery("from Employee");
		
		//Saving Result to list
		List<Employee> list = query.getResultList();

		
		// Review Fetched Result
		Display.displayAll(list);

	}

}
