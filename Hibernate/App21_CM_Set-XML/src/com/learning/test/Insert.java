package com.learning.test;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.entity.Question;
import com.learning.util.HibernateUtil;

public class Insert {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		HashSet<String> set1 = new HashSet<String>();
		set1.add("Java is a programming language");
		set1.add("Java is a platform");
		set1.add("Java is used Globally");
		set1.add("Java is a platform");					// Adding twice to check duplicate record insertion

		HashSet<String> set2 = new HashSet<String>();
		set2.add("Servlet is an Interface");
		set2.add("Servlet is an API");
		set2.add("Servlet is an Interface");			// Adding twice to check duplicate record insertion

		Question q1 = new Question();
		q1.setQname("What is Java");
		q1.setAnswers(set1);

		Question q2 = new Question();
		q2.setQname("What is Servlet");
		q2.setAnswers(set2);

		session.persist(q1);
		session.persist(q2);

		tx.commit();
		session.close();
	}

}
