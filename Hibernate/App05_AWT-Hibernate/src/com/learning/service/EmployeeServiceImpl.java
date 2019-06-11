package com.learning.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class EmployeeServiceImpl implements EmployeeService {

	private Employee emp;

	public Employee search(int eno) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			emp = (Employee) session.get(Employee.class, eno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
}
