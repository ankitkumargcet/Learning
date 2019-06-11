package com.learning.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.entity.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;

		try {
			config = new Configuration();
			config.configure("myconfig.xml");
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Employee emp = new Employee();
			emp.setEno(555);
			session.delete(emp);

			tx.commit();
			System.out.println("Employee Deleted Sucessfully");

		} catch (Exception e) {
			tx.rollback();
			System.out.println("Employee Deleted Sucessfull");

		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
