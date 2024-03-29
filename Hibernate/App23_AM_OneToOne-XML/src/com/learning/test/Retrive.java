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

		TypedQuery<Employee> query = session.createQuery("from Employee");
		List<Employee> list = query.getResultList();

		Iterator<Employee> itr = list.iterator();
		while (itr.hasNext()) {
			Employee e = itr.next();
			System.out.println("Employee ID: " + e.getEno());
			System.out.println("Employee Name: " + e.getEname());
			System.out.println("Employee Email: " + e.getEmail());

			Address add = e.getAddress();
			System.out.println("Address: \n" + add.getAddressLine1());
			System.out.println(add.getCity() + "," + add.getState() + "," + add.getCountry());
			System.out.println("Pincode: " + add.getPincode());
		}
		System.out.println();
	}
}
