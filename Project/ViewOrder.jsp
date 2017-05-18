<%@page import="com.*"%>
<%@page import="java.util.*"%>
<%@page import="com.DBUtilities"%>


<%!
//for testing setting username 
//DBUtilities db = new DBUtilities();
public List<Order> ord = new ArrayList<Order>();
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
			<li style="float:right";><a href="index.jsp">Logout</a></li>		
        </ul>
</nav>
<section id = "content" style="min-height:500px">
<div align="center" style = "font-family: Century Gothic, Arial, sans-serif";>
<h2>Order Details</h2>
<%
String OrderId = request.getParameter("orderid");
ord = com.DBUtilities.getOrders(OrderId);
for (Order o : ord) {
%>
<table>
<tr><td>Order id:</td><td><b><p><%=OrderId%></p></b></td></tr>
<tr><td>User: </td><td><small><i><p><%=o.getUserid()%></p></i></small></td></tr>
<tr><td>Type: </td><td><b><p><%=o.getOrderType()%></p></b></td></tr>
<tr><td>Location: </td><td><b><p><%=o.getLocation()%></p></b></td></tr>
<tr><td>Status: </td><td><b><p><%=o.getStatus()%></p></b></td></tr>
<tr><td>Order date: </td><td><b><p><%=o.getOrderDate()%></p></b></td></tr>
<tr><td>Total: </td><td><b><p>$<%=o.getTotal()%></p></b></td></tr>
</table>
<br>
<%}%>
</div>
</section>

<aside class="sidebar" style="float:left">
		<ul>	
			<div ><li align = "center"><a href="index1.jsp" >HOME</a></li></div>	
            <div ><li align = "center"><a href="Menu.jsp" >MENU</a></li></div>
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