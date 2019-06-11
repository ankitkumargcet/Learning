package com.learning.service;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class EmployeeServiceImpl implements EmployeeService {
	private String status = "";
	private SessionFactory sessionFactory = null;
	private Session session = null;
	private Transaction tx = null;
	private Employee employee = null;

	@Override
	public String insertEmployee(Employee emp) {
		try {
			sessionFactory = HibernateUtil.getSessioFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			employee = (Employee) session.get(Employee.class, emp.getEno());
			if (employee != null) {
				System.out.println("Employee with Employee Number " + emp.getEno() + " already Exists");
				status = "failed";
			} else {
				employee = new Employee();
				employee.setEname(emp.getEname());
				employee.setEsal(emp.getEsal());
				employee.setEaddr(emp.getEaddr());
				Serializable pk_value = session.save(employee);
				if (pk_value != null) {
					tx.commit();
					System.out.println("Employee inserted successfully with ENO:" + pk_value);
					status = "success";
				} else {
					tx.rollback();
					System.out.println("Failed to insert Employee");
					status = "failed";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
