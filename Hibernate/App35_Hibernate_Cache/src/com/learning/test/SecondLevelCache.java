package com.learning.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class SecondLevelCache {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		// Using Two Sessions but still query fired only once for both employee with
		// EMPID = 111 and EMPID = 222
		Session session1 = sessionFactory.openSession();
		Employee emp1 = (Employee) session1.load(Employee.class, 111);
		System.out.println("Using First Session");
		System.out.println("[ " + emp1.getEno() + ", " + emp1.getEname() + ", " + emp1.getEsal() + ", " + emp1.getEaddr() + " ]");

		Employee emp2 = (Employee) session1.load(Employee.class, 111);
		System.out.println("Using First Session");
		System.out.println("[ " + emp2.getEno() + ", " + emp2.getEname() + ", " + emp2.getEsal() + ", " + emp2.getEaddr() + " ]");

		Employee emp3 = (Employee) session1.load(Employee.class, 222);
		System.out.println("Using First Session");
		System.out.println("[ " + emp3.getEno() + ", " + emp3.getEname() + ", " + emp3.getEsal() + ", " + emp3.getEaddr() + " ]");
		session1.close();

		System.out.println();
		
		// Set cache value to true/false in hibernate.cfg.xml to see the difference in query firing
		Session session2 = sessionFactory.openSession();
		Employee emp4 = (Employee) session2.load(Employee.class, 111);
		System.out.println("Using Second Session");
		System.out.println("[ " + emp4.getEno() + ", " + emp4.getEname() + ", " + emp4.getEsal() + ", " + emp4.getEaddr() + " ]");
		
		Employee emp5 = (Employee) session2.load(Employee.class, 222);
		System.out.println("Using Second Session");
		System.out.println("[ " + emp5.getEno() + ", " + emp5.getEname() + ", " + emp5.getEsal() + ", " + emp5.getEaddr() + " ]");
		session2.close();

	}

}
