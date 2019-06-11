package com.learning.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.learning.entity.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;

		try {
			config = new Configuration();
			config.configure();
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();

			tx = session.getTransaction(); 			// It will create the transaction object but will not start the transaction
			tx.begin(); 							// It will now start the transaction

			Employee emp = new Employee();
//			emp.setEno(111);						// Commented as next operation is performing saveOrUpdate()
//			emp.setEname("AAA");
//			emp.setEsal(5000);
//			emp.setEaddr("HYD");
//			session.update(emp); 					// It will only update the records once committed
			
			emp.setEno(444);
			emp.setEname("DDD");
			emp.setEsal(8000);
			emp.setEaddr("HYD");
			session.saveOrUpdate(emp);				// If record not available then it will insert record, if available then will update the record once committed

			tx.commit();						 	// It will make all the session permanent in the Database
			System.out.println("Employee Inserted/Updated Sucessfully");

		} catch (Exception e) {
			tx.rollback(); 							// It will roll back the update if transaction is failed
			System.out.println("Employee Inserted/Updation Failure: " + e.getMessage());

		} finally {
			session.close();
			sessionFactory.close();					// Make sure to close all the resources
		}

	}

}
