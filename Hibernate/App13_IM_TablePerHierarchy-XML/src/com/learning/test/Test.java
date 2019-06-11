package com.learning.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learning.entity.ContractEmployee;
import com.learning.entity.Employee;
import com.learning.entity.RegularEmployee;
import com.learning.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Employee emp1 = new Employee();
		emp1.setEname("Gaurav Chawla");

		RegularEmployee emp2 = new RegularEmployee();
		emp2.setEname("Vivek Kumar");
		emp2.setSalary(50000);
		emp2.setBonus(5);

		ContractEmployee emp3 = new ContractEmployee();
		emp3.setEname("Arjun Kumar");
		emp3.setPayPerHour(1000);
		emp3.setContractDuration("15 hours");

		session.persist(emp1);
		session.persist(emp2);
		session.persist(emp3);

		tx.commit();
		System.out.println("Employees inserted successfully");
		session.close();
		sessionFactory.close();

	}

}
