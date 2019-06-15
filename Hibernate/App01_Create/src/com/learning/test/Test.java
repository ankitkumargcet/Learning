package com.learning.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.entity.Employee;

public class Test {

	public static void main(String[] args) throws Exception {
		Configuration config = new Configuration();								// It will create Configuration Object without encapsulation		
		config.configure(); 													// It will load the default configuration file 'hibernate.cfg.xml' and encapsulate
		SessionFactory sessionFactory = config.buildSessionFactory();			// It will load the driver and manage the connections
		Session session = sessionFactory.openSession();							// It will initiate the Session
		Transaction tx = session.beginTransaction();							// It will start transaction (i.e: required for Non-Select Operations(no auto-commit mode))
		
		Employee emp = new Employee();
		emp.setEno(111);
		emp.setEname("AAA");
		emp.setEsal(5000);
		emp.setEaddr("HYD");
//		int eno = (int)session.save(emp);										// It will return Primary Key(i.e: saving to confirm insertion)	//commented Because of persist()
		
		
		emp.setEno(222);														// Not Commenting as resetting the above setted values for persist() example
		emp.setEname("BBB");
		emp.setEsal(6000);
		emp.setEaddr("HYD");
//		session.persist(emp);													// Its Return type is Void 		//commented Because of another insertion below	 												
//		System.out.println("Employee Inserted Sucessfully");
		
		
		emp.setEno(555);														// Not Commenting as resetting the above setted values for persist() example
		emp.setEname("EEE");
		emp.setEsal(9000);
		emp.setEaddr("HYD");
		session.persist(emp);
		
		
		tx.commit();															// Save Record permanently into the database	
		System.out.println("Employee Inserted Sucessfully");
		
		
//		if(eno==111) {															// Commented because it was used with save() to show success result
//			System.out.println("Employee Inserted Sucessfully");
//		}else {
//			System.out.println("Employee Insertion Failed");
//		}

		
		session.close();														// It will close the Session
		sessionFactory.close();													// It will close the Session Factory
				
	}

}
