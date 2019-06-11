package com.learning.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
			System.out.println("Asked by: " + q.getUsername());

			Map<String, String> map = q.getAnswers();
			Set<Map.Entry<String, String>> set = map.entrySet();

			Iterator<Map.Entry<String, String>> itr2 = set.iterator();
			while (itr2.hasNext()) {
				Map.Entry<String, String> e = itr2.next();
				System.out.println("Answer: " + e.getKey());
				System.out.println("Posted By: " + e.getValue());
			}
			System.out.println();
		}

	}

}
