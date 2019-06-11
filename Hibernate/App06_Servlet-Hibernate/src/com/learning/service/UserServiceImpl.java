package com.learning.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.entity.User;
import com.learning.util.HibernateUtil;

public class UserServiceImpl implements UserService {

	@Override
	public String checkLogin(String username, String password) {
		String status = "";
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			User user = (User) session.get(User.class, username);
			if (user == null) {
				status = "failure";
			} else {
				if (user.getPassword().equals(password)) {
					status = "success";
				} else {
					status = "failure";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
