package com.learning.dao;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.learning.beans.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	String status = "";
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	@Override
	public String insertEmployee(Employee emp) {
		Integer in = (Integer) hibernateTemplate.save(emp);
		if (in == emp.getEno()) {
			status = "Success";
		} else
			status = "Failed";
		return status;
	}

	@Transactional
	@Override
	public Employee searchEmployee(int eno) {
		Employee emp = hibernateTemplate.get(Employee.class, eno);
		return emp;
	}

	@Transactional
	@Override
	public String updateEmployee(Employee emp) {
		hibernateTemplate.update(emp);
		status = "success";
		return status;
	}

	@Transactional
	@Override
	public String deleteEmployee(int eno) {
		Employee emp = hibernateTemplate.get(Employee.class, eno);
		if (emp != null) {
			hibernateTemplate.delete(emp);
			status = "Success";
		} else {
			status = "Employee does not Exist";
		}

		return status;
	}

}
