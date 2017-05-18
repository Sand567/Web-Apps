<%@page import="com.*"%>
<%@page import="java.util.*"%>

<%
//for testing setting username 

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
<%
String orderNum = ""+((int)(Math.random()*9000)+1000);
System.out.println(orderNum);
    ShoppingCart cart;
String user;
synchronized(session) {
cart = (ShoppingCart)session.getAttribute("shoppingCart");
user = session.getAttribute("fname").toString();
}
int ordertotal =0;
System.out.println("username in success page "+user);
 List itemsOrdered = cart.getItemsOrdered();
 System.out.println("Size is"+itemsOrdered.size());
for(int i=0; i<itemsOrdered.size(); i++) {
	
   ItemOrder order = (ItemOrder)itemsOrdered.get(i);
   MenuItem pr = order.getItem();
   DBUtilities.addOrderItem(orderNum,pr.getItemid(),pr.getIname(),pr.getPrice(),order.getNumItems(),pr.getPrice()*order.getNumItems());
   ordertotal = ordertotal + pr.getPrice()*order.getNumItems();
}
Date mydate = new Date();
 java.text.SimpleDateFormat sdf = 
        new java.text.SimpleDateFormat("YYYY-MM-dd");

String currentTime = sdf.format(mydate);

//Order orderObj = new Order(orderNum,user,request.getParameter("ordertype"),request.getParameter("location"),"Ordered",currentTime,ordertotal);

DBUtilities.addOrder(orderNum,user,request.getParameter("ordertype"),request.getParameter("location"),"Ordered",currentTime,ordertotal);
 
synchronized(session) {
session.setAttribute("shoppingCart", null);
}

%>

<p>Hey <%=session.getAttribute("fname")%>, Your order has been successfully placed. </p>
<p>Your Order No is: <%=orderNum%></p>
</div>
<%
System.out.println("location "+request.getParameter("location"));
System.out.println("ordertype "+request.getParameter("ordertype"));
%>

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


	