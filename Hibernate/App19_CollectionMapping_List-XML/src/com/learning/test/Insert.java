package com.learning.test;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.entity.Question;
import com.learning.util.HibernateUtil;

public class Insert {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Java is a programming language");    
	    list1.add("Java is a platform");
	    list1.add("Java is used globally");
	    
	    ArrayList<String> list2 = new ArrayList<String>();
	    list2.add("Servlet is an Interface");    
	    list2.add("Servlet is an API");
	    
	    Question ques1 = new Question();
	    ques1.setQname("What is Java");
	    ques1.setAnswers(list1);
	    
	    Question ques2 = new Question();
	    ques2.setQname("What is Servlet");
	    ques2.setAnswers(list2);
	    
	    session.persist(ques1);
	    session.persist(ques2);
	    
	    tx.commit();
	    System.out.println("Saved Sucessfully");
	    session.close();
	    
	}

}
