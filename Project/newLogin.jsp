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
	String role;
%>

<%
	String Fname = request.getParameter("fname");
	String password  = request.getParameter("password");

	role = DBUtilities.getUsers(Fname,password);
	//System.out.println(role);
	if(role.equals("Administrator")) {
		session.setAttribute("fname",Fname);
		response.sendRedirect("admin.jsp");
	}
	else if(role.equals("Customer")) {
		session.setAttribute("fname",Fname);
		response.sendRedirect("index1.jsp");
	}
	else {%>
<h3>Invalid Password</h3>
	<%}
%>
	