package com.learning.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.learning.entity.Address;
import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class Retrive {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		TypedQuery<Employee> employee = session.createQuery("from Employee");
		List<Employee> list = employee.getResultList();

		Iterator<Employee> itr = list.iterator();
		while (itr.hasNext()) {
			Employee emp = itr.next();
			System.out.println("Employee ID: " + emp.getEid());
			System.out.println("Employee Name: " + emp.getEname());
			System.out.println("Employee Email: " + emp.getEmail());
			Address add = emp.getAddress();
			System.out.println("Address: " + add.getAddressLine1() + ", " + add.getCity() + ", " + add.getState() + ", "
					+ add.getCountry());
			System.out.println("Pincode: " + add.getPincode());

			System.out.println();
		}

	}

}
