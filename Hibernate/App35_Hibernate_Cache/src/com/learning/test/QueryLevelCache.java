package com.learning.test;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class QueryLevelCache {

	@SuppressWarnings({ "unchecked", "unused" })
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		TypedQuery<Employee> query = session.createQuery("from Employee");

		// If calling without setting cacheable then query is executing 3 times
		System.out.println("=========Without setting Cachable=========");
		List<Employee> list1 = query.getResultList();
		List<Employee> list2 = query.getResultList();
		List<Employee> list3 = query.getResultList();
		
		System.out.println();
		
		// If calling after setting cacheable then query is executing once
		System.out.println("=========After setting Cachable=========");
		query.setHint("org.hibernate.cacheable", Boolean.TRUE);
		List<Employee> list4 = query.getResultList();
		List<Employee> list5 = query.getResultList();
		List<Employee> list6 = query.getResultList();

	}

}
