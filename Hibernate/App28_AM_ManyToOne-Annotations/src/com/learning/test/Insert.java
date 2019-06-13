package com.learning.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.entity.Address;
import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class Insert {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Address add1 = new Address();
		add1.setAddressLine1("G-13,Sector 3");
		add1.setCity("Noida");
		add1.setState("UP");
		add1.setCountry("India");
		add1.setPincode(201301);

		Employee emp1 = new Employee();
		emp1.setEname("Ravi Malik");
		emp1.setEmail("ravi@gmail.com");
		emp1.setAddress(add1);

		Employee emp2 = new Employee();
		emp2.setEname("Anuj Verma");
		emp2.setEmail("anuj@gmail.com");
		emp2.setAddress(add1);

		session.persist(emp1);
		session.persist(emp2);

		tx.commit();
		System.out.println("Saved Sucessfully");
		session.close();

	}

}
