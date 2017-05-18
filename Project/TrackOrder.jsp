<%@page import="com.*"%>
<%@page import="java.util.*"%>

<%
//for testing setting username 
 session.setAttribute("username", "testuser");

%>


<!doctype html>
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
			<li style="float:right";><a href="Register.jsp">Register</a></li>
            <li style="float:right";><a href="Login.jsp">Login</a></li>
        </ul>
</nav>
<section id = "content" style="min-height:500px">
<h1>Please enter the order details to track</h1>
<form action="trackorder" method="get">
Order id : <input type="text" name="                              ">
<input class="submit" type="submit" value="Search">    
</form>
</section>

<aside class="sidebar" style="float:left">
		<ul>	
			<div ><li align = "center"><a href="index.jsp" >HOME</a></li></div>	
            <div ><li align = "center"><a href="#" >MENU</a></li></div>
			<div ><li align = "center"><a href="TableBookingForm.jsp">DINE-IN</a></li></div>
			<div ><li align = "center"><a href="location.jsp">LOCATIONS</a></li></div>
			<div ><li align = "center"><a href="TrackOrder.jsp">TRACK ORDER</a></li></div>
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


	