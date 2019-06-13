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
		ans1.setAname("Java is a Programming Language");
		ans1.setPostedBy("Ravi Malik");

		Answer ans2 = new Answer();
		ans2.setAname("Java is a platform");
		ans2.setPostedBy("Sudhi");

		Question q1 = new Question();
		q1.setQname("What is Java");

		ArrayList<Answer> list1 = new ArrayList<Answer>();
		list1.add(ans1);
		list1.add(ans2);

		q1.setAnswers(list1);

		Answer ans3 = new Answer();
		ans3.setAname("Java is a Programming Language");
		ans3.setPostedBy("Ravi Malik");

		Answer ans4 = new Answer();
		ans4.setAname("Java is a platform");
		ans4.setPostedBy("Sudhi");

		Question q2 = new Question();
		q2.setQname("What is Java");

		ArrayList<Answer> list2 = new ArrayList<Answer>();
		list2.add(ans3);
		list2.add(ans4);

		q2.setAnswers(list2);

		session.persist(q1);
		session.persist(q2);

		tx.commit();
		System.out.println("Data Saved Sucessfully");
		session.close();

	}

}
