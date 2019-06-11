package com.learning.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class EmployeeServiceImpl implements EmployeeService {
	private SessionFactory sessionFactory = null;
	private Session session = null;
	private Transaction tx = null;
	private Employee employee = null;
	String status = "";

	@Override
	public String insertEmployee(Employee emp) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		employee = (Employee) session.get(Employee.class, emp.getEno());
		if (employee != null) {
			System.out.println("Employee with Employee Number " + emp.getEno() + " Already Exists");
			status = "failed";
		} else {
			employee = new Employee();
			employee.setEno(emp.getEno());
			employee.setEname(emp.getEname());
			employee.setEsal(emp.getEsal());
			employee.setEaddr(emp.getEaddr());
			session.save(employee);
			tx.commit();
			status = "success";
		}
		return status;
	}

}
