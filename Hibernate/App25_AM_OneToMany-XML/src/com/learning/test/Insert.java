package com.learning.test;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.entity.Answer;
import com.learning.entity.Question;
import com.learning.util.HibernateUtil;

public class Insert {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Answer ans1 = new Answer();
		ans1.setAname("Java is a programming language");
		ans1.setPostedBy("Ravi Malik");

		Answer ans2 = new Answer();
		ans2.setAname("Java is a platform");
		ans2.setPostedBy("Sudhir Kumar");

		Answer ans3 = new Answer();
		ans3.setAname("Servlet is an Interface");
		ans3.setPostedBy("Jai Kumar");

		Answer ans4 = new Answer();
		ans4.setAname("Servlet is an API");
		ans4.setPostedBy("Arun");

		ArrayList<Answer> l1 = new ArrayList<Answer>();
		l1.add(ans1);
		l1.add(ans2);

		ArrayList<Answer> l2 = new ArrayList<Answer>();
		l2.add(ans3);
		l2.add(ans4);

		Question q1 = new Question();
		q1.setQname("What is Java");
		q1.setAnswers(l1);

		Question q2 = new Question();
		q2.setQname("What is Servlet");
		q2.setAnswers(l2);

		session.persist(q1);
		session.persist(q2);

		tx.commit();
		System.out.println("Saved Sucesfully");
		session.close();

	}

}
