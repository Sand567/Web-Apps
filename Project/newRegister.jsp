<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">

<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.Users"%>
<%@ page import="com.DBUtilities"%>

<%!
	Users user;
%>

<%
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String confirmPass = request.getParameter("confirmPass");
	
	if (password.equals(confirmPass)) {
		user = new Users(fname,lname,email,password);
		int i = DBUtilities.registerUsers(user);
		
		if (i > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("testLogin.jsp");
			rd.forward(request,response);
		}
	}
	else {%>
<h4> Incorrect Password, Retry!</h4>	
	<%}
%>


