package com.learning.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.learning.entity.Question;
import com.learning.util.HibernateUtil;

public class Retrive {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		TypedQuery<Question> query = session.createQuery("from Question");
		List<Question> list = query.getResultList();

		Iterator<Question> itr = list.iterator();
		while (itr.hasNext()) {
			Question q = itr.next();
			System.out.println("Question: " + q.getQname() + "?");

			
			List<String> l = q.getAnswers();
			Iterator<String> itr2 = l.iterator();
			while (itr2.hasNext()) {
				System.out.println(itr2.next());
			}
		}
		session.close();
	}

}
