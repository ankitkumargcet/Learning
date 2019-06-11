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

		Employee emp1 = new Employee();
		emp1.setEname("Ravi Malik");
		emp1.setEmail("ravimalik@gmail.com");

		Address add1 = new Address();
		add1.setAddressLine1("G-21,Lohia nagar");
		add1.setCity("Ghaziabad");
		add1.setState("UP");
		add1.setCountry("India");
		add1.setPincode(201301);

		emp1.setAddress(add1);
		add1.setEmployee(emp1);

		session.persist(emp1);

		tx.commit();
		System.out.println("Saved Sucessfully");
		session.close();
	}

}