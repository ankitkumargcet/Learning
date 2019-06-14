package com.learning.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			Employee emp = new Employee();
			emp.setEno(2);
			emp.setEname("Ramesh");
			emp.setEsal(10000);
			emp.setEaddr("HYD");
			session.persist(emp);
			tx.commit();
			System.out.println("Record Inserted Successfully");
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Record Insertion Failed: " + e.getClass().getSimpleName());

		}

	}

}
