package com.learning.test;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class Test_04_DeleteRecords {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		// Creating Query for Delete Operation
		TypedQuery<Employee> query = session.createQuery("delete from Employee where eno=:en");

		// Setting Parameters i.e- not hard coding with the query
		query.setParameter("en", 777);

		// Executing query
		int status = query.executeUpdate(); // AutoCommit for DML

		// Transaction is required but not necessary to commit as it is in AutoCommit
		tx.commit(); 						// <=== not necessary
		
		// If operation performed then will return status as 1
		// If no operation performed then will return status as 0
		System.out.println("Record Deleted Sucessfully with status code: " + status);

		// Fetching records after delete operation
		System.out.println();
		Display.displayAll(session.createQuery("from Employee").getResultList());

	}

}
