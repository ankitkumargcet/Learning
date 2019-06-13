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
		List<Question> que = query.getResultList();

		// No record is pulling until we call the attribute if lazy loading is enabled
		// This can be reviewed by setting lazy True/False in question.hbm.xml file
		Iterator<Question> itr = que.iterator();
		while (itr.hasNext()) {
			Question q = itr.next();
			System.out.println("Question: " + q.getQname() + "?");
			List<Answer> l = q.getAnswers();
			Iterator<Answer> itr2 = l.iterator();
			// If false then all queries will fire at start of Question object creation
			// If true then query will fire only when we call "answers" property
			// Change the values of lazy in question.hbm.xml and check
			// Difference can be checked on console with query firing position
			while (itr2.hasNext()) {
				Answer ans = itr2.next();
				System.out.println("Answer\t: \"" + ans.getAname() + "\", Posted By:" + ans.getPostedBy());
			}
			System.out.println();
		}
	}

}
