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
	    list1.add("Java is used Globally");
	        
	    ArrayList<String> list2=new ArrayList<String>();    
	    list2.add("Servlet is an Interface");    
	    list2.add("Servlet is an API");
	    
	    Question q1 = new Question();
	    q1.setQname("What is Java");
	    q1.setAnswers(list1);
	    
	    Question q2 = new Question();
	    q2.setQname("What is Servlet");
	    q2.setAnswers(list2);
	    
	    session.persist(q1);
	    session.persist(q2);
	    tx.commit();
	    System.out.println("Saved Sucessfully");

	}

}
