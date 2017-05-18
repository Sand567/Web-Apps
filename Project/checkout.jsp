<%@page import="com.*"%>
<%@page import="java.util.*"%>

<%
//for testing setting username 
 session.setAttribute("username", "testuser");
		
System.out.println("val "+request.getParameter("ordertype"));

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
             <li style="float:right";><a href="viewcart.jsp">ViewCart</a></li>
        </ul>
</nav>
<section id = "content" style="min-height:500px" >
<div align="center" style = "font-family: Century Gothic, Arial, sans-serif";>
<%

     List itemsOrdered = new ArrayList ();
     double totalcost=0;              
    ShoppingCart cart;
    synchronized(session) {
      cart = (ShoppingCart)session.getAttribute("shoppingCart");
       itemsOrdered = cart.getItemsOrdered();
      }
    ItemOrder order;

    for(int i=0; i<itemsOrdered.size(); i++) {
        order = (ItemOrder)itemsOrdered.get(i);
        totalcost = totalcost + order.getTotalCost();
    }


out.println("<h4>Bill Amount : $"+totalcost+"<h4>");
out.println("</br>");
String myvar1=
"<form method=\"post\" style=\"text-align: center\" action=\"success.jsp\">"+
"<input type=\"text\" name=\"name\" placeholder=\"Full Name\"><br>"+
"<input type=\"text\" name=\"address\" placeholder=\"Address\"><br>"+
"<input type=\"number\" name=\"card\" placeholder=\"Credit Card No\"><br>"+
"<input type=\"password\" name=\"card\" placeholder=\"CVV\"><br>"+
"<input  type=\"hidden\" name=\"ordertype\" value=\""+request.getParameter("ordertype")+"\">"+
"<input  type=\"hidden\"  name=\"location\" value=\""+request.getParameter("selectLoc")+"\">"+
"<input class=\"submit\" type=\"submit\" value=\"Make Payment\">"+
"</form>"+
"</body>"+
"</html>";
out.println(myvar1);
%>
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


	