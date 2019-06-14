package com.learning.test;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.entity.Employee;
import com.learning.util.HibernateUtil;

public class Test_03_UpdateRecords {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		// Creating Query for Update Operation
		TypedQuery<Employee> query = session.createQuery("update Employee set esal=:es where eno=:en");

		// Setting Parameters i.e- not hard coding with the query
		query.setParameter("en", 444);
		query.setParameter("es", Float.parseFloat("8000"));

		// Executing query
		int status = query.executeUpdate(); // AutoCommit for DML

		// Transaction is required but not necessary to commit as it is in AutoCommit
		tx.commit(); 						// <=== not necessary
		System.out.println("Record Updated Sucessfully with status code: " + status);

		// Fetching records after update operation
		System.out.println();
		Display.displayAll(session.createQuery("from Employee").getResultList());

	}

}
