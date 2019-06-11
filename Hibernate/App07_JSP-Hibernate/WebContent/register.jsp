<%@page import="com.learning.factory.UserServiceFactory"%>
<%@page import="com.learning.service.UserService"%>
<%!String username;
	String password;
	String email;
	String mobile;
	UserService userService;
	String status = "";
	String message = "";%>

<%
	username = request.getParameter("username");
	password = request.getParameter("password");
	email = request.getParameter("email");
	mobile = request.getParameter("mobile");
	userService = UserServiceFactory.getUserService();
	status = userService.register(username, password, email, mobile);
	if (status.equals("success")) {
		message = "User Registration Successful";
	}
	if (status.equals("existed")) {
		message = "User Already Exists";
	}
	if (status.equals("failure")) {
		message = "User Registration Failed";
	}
	request.setAttribute("status_Message", message);
%>
<jsp:forward page="status.jsp" />