package com.learning.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	static {
		try {
			Configuration config = new Configuration();
			config.configure("/com/learning/resources/hibernate.cfg.xml");
			sessionFactory = config.buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Error While Establishing Connection : " + e.getMessage());
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
