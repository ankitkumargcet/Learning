package com.learning.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learning.entity.ContractEmployee;
import com.learning.entity.Employee;
import com.learning.entity.RegularEmployee;
import com.learning.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Employee emp1 = new Employee();
		emp1.setEname("Gaurav Chaudhary");

		RegularEmployee emp2 = new RegularEmployee();
		emp2.setEname("Vishal Shekher");
		emp2.setSalary(5000);
		emp2.setBonus(500);
		

		ContractEmployee emp3 = new ContractEmployee();
		emp3.setEname("Rajesh Sharma");
		emp3.setPayPerHour(800);
		emp3.setContractDuration("12 Hours");
		
		
		session.persist(emp1);
		session.persist(emp2);
		session.persist(emp3);

		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
