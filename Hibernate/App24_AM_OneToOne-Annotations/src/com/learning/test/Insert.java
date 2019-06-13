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
		emp1.setEname("Kunal Mathur");
		emp1.setEmail("kunalmathur@gmail.com");

		Address add1 = new Address();
		add1.setAddressLine1("F-117,7th Cross, 19th Main");
		add1.setCity("Bangalore");
		add1.setState("Karnataka");
		add1.setCountry("India");
		add1.setPincode(560037);

		emp1.setAddress(add1);
		add1.setEmployee(emp1);

		session.persist(emp1);

		tx.commit();
		System.out.println("Record Saved Sucessfully");
		session.close();
	}

}
