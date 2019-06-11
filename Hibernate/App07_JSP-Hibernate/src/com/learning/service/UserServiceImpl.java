package com.learning.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learning.entity.User;
import com.learning.util.HibernateUtil;

public class UserServiceImpl implements UserService {
	String status = "";

	@Override
	public String register(String username, String password, String email, String mobile) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			User user = (User) session.get(User.class, username);
			if (user == null) {
				Transaction tx = session.beginTransaction();
				user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				user.setMobile(mobile);
				String pk_val = (String) session.save(user);
				tx.commit();
				if (pk_val.equals(username)) {
					status = "success";
				} else {
					status = "failure";
				}
			} else {
				status = "existed";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
