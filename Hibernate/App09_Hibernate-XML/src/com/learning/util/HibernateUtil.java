package com.learning.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration config = new Configuration();
			sessionFactory = config.configure("/com/learning/resources/hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Failed to establish Connection with the Database: " + e.getMessage());
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
