package com.learning.test;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.entity.Question;
import com.learning.util.HibernateUtil;

public class Insert {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("Java is a programming language", "John Milton");
		map1.put("Java is a platform", "Ashok Kumar");

		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Servlet technology is a server side programming", "John Milton");
		map2.put("Servlet is an Interface", "Ashok Kumar");
		map2.put("Servlet is a package", "Rahul Kumar");

		Question q1 = new Question();
		q1.setQname("What is Java");
		q1.setUsername("Alok");
		q1.setAnswers(map1);

		Question q2 = new Question();
		q2.setQname("What is Servlet");
		q2.setUsername("Jai Dixit");
		q2.setAnswers(map2);

		session.persist(q1);
		session.persist(q2);

		tx.commit();
		session.close();

	}

}
