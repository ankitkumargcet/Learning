package com.learning.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.learning.entity.Answer;
import com.learning.entity.Question;
import com.learning.util.HibernateUtil;

public class Retrive {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		TypedQuery<Question> query = session.createQuery("from Question");
		List<Question> ques = query.getResultList();

		Iterator<Question> itr = ques.iterator();
		while (itr.hasNext()) {
			Question q = itr.next();
			System.out.println("Question: " + q.getQname() + "?");
			List<Answer> list = q.getAnswers();

			Iterator<Answer> itr2 = list.iterator();
			while (itr2.hasNext()) {
				Answer ans = itr2.next();
				System.out.println("Answer: " + ans.getAname() + ", Posted By: " + ans.getPostedBy());
			}
			System.out.println();
		}

	}

}
