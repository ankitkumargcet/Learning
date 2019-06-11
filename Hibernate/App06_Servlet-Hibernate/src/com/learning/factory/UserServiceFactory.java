package com.learning.factory;

import com.learning.service.UserService;
import com.learning.service.UserServiceImpl;

public class UserServiceFactory {
	private static UserService userService;
	
	static {
		userService = new UserServiceImpl();
	}

	public static UserService getUserService() {
		return userService;
	}

}
