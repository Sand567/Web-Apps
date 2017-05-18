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
			<li style="float:right";><a href="index.jsp">Logout</a></li>		
             <li style="float:right";><a href="viewcart.jsp">ViewCart</a></li>
        </ul>
</nav>
<section id = "content" style="min-height:500px">
<div align="center" style = "font-family: Century Gothic, Arial, sans-serif";>
<%
 List  itemsOrdered = new ArrayList();
ShoppingCart cart;
    synchronized(session) {
      cart = (ShoppingCart)session.getAttribute("shoppingCart");
    itemsOrdered = cart.getItemsOrdered();
    }
    if (itemsOrdered == null) {
     
    }
   
    

    if (itemsOrdered.size() == 0) {
      out.println("<p id=\"message\">No Items</p>");
    } else {
      %>
      <form action="checkout.jsp" >
      <div style="float:right">
      <h3>Location:   <select name="selectLoc" ></h3>
  <%
  List<Location> loc =DBUtilities.getRestaurantLocations();
 
for (Location l : loc ){
	
  out.println("<option value="+l.getLocation()+">"+l.getAddress()+"</option>");
			
}

%>
      </select>
    	<h3>Order Type: <select name="ordertype"></h3>
    	  <option value="Home Delivery">Home Delivery</option>
    	  <option value="Takeaway">Takeaway</option>
    	</select>
    	</div>
    	<% 
       for(int i=0; i<itemsOrdered.size(); i++) {
       ItemOrder order = (ItemOrder)itemsOrdered.get(i);
        out.println("  <h3> Item: " + order.getItem().getIname()+"</h3>");
    out.println("<H> Quantity: "+ order.getNumItems()+"</h3>");
      }
      out.println("</br></br>");
    }
 // out.println("<a href=\"checkout.jsp\">Proceed to checkout</a>");
   
 %>
 

<input type="submit" value="Proceed to checkout">
</form>
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
			<!--<img src = "images/Ratfi.JPG" width = "300" height = "250"/>-->
               
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


	