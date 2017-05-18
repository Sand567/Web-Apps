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

<% 
			session.removeAttribute("fname");
			session.invalidate();
			
			if(session == null)
			{
				response.sendRedirect("logoutRedirect.jsp");
			}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Home Page</title>
<link rel="stylesheet" href="allstyle.css" type="text/css" />
</head>
<body>
<div class="container">
    <header>
    	<h1>American <span>Spice</span></h1>
        <h2>The taste of America !</h2>
		<img src = "images/thumb.jpeg" alt = "Restaurant" />
    </header>
</div>
<nav>
		<ul>
            <li style="float:right";><a href="Login.jsp">Login</a></li>
			<li style="float:right";><a href="Register.jsp">Register</a></li>
        </ul>
</nav>
<section id = "content">
<h3>Customer Logged In</h3>
</section>
<aside class="sidebar" style="float:left">
		<ul>		
            <div ><li align = "center"><a href="#" >MENU</a></li></div>
			<div ><li align = "center"><a href="#">DINE-IN</a></li></div>
			<div ><li align = "center"><a href="#">LOCATIONS</a></li></div>
			<div ><li align = "center"><a href="#">TRACK ORDER</a></li></div>
			<div ><li align = "center"><a href="#">SHARE EXPERIENCE</a></li></div>
			<div ><li align = "center"><a href="#">HELP</a></li></div>
			<img src = "images/Ratfi.JPG" width = "300" height = "250"/>
               
		</ul>		
</aside>
<div class="clear"></div>
<footer>	
<div class="footer-bottom">
            <center><p><strong>&copy; American Spice 2016.</strong> <a href="#">www.AmericanSpice.com</a></p></center>
</div>
</footer>

</body>
</html>

