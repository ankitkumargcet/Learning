package com.learning.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learning.entity.Address;
import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Employee emp1 = new Employee(111, "Ankit Kumar", 40000, new Address("Bangalore", "India", 560076));
		Employee emp2 = new Employee(222, "Animesh Kumar", 50000, new Address("Bangalore", "India", 560076));

		session.save(emp1);
		session.save(emp2);

		tx.commit();
		System.out.println("Employee Details Inserted");
		session.close();
		sessionFactory.close();

	}

}
