<%@page import="com.*"%>
<%@page import="java.util.*"%>

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

<%
 int shoppingitems=0;
try {
	
	
	   
	ShoppingCart shoppingcartNum;
		
	    ShoppingCart cart =null;
    
      synchronized(session) {
      cart = (ShoppingCart)session.getAttribute("shoppingCart");
      if (cart == null) {
        cart = new ShoppingCart();
        session.setAttribute("shoppingCart", cart);
      }
      }
     
    synchronized(session) {
      List itemsOrdered = cart.getItemsOrdered();
      shoppingitems=itemsOrdered.size();
    }
	
	
} catch(Exception e) {
	
}
%>
		<ul>
			<li style="float:right";><a href="index.jsp">Logout</a></li>		
             <li style="float:right";><a href="viewcart.jsp">ViewCart<%=" "%>(<%=shoppingitems%>)</a></li>
          

        </ul>
</nav>
<section id = "content" style="min-height:500px">
<div align="center" style = "font-family: Century Gothic, Arial, sans-serif";>
<%

List<MenuItem> menu = DBUtilities.getMenuItems();
for (MenuItem m : menu ){
	
	out.println("<form method=\"get\" action=\"addtocart.jsp\">");
	out.println("<b><p>"+m.getIname()+"</p></b>");
	out.println("<img  style=\"width:200px;height:200px;border-radius:50%\" src =\""+m.getImage()+"\">");
	out.println("<div float=\"center\" style=\"max-width:200px\">");
	out.println("<small><i><p>"+m.getDescription()+"</p></i></small>");
	out.println("</div>");
	out.println("<b><p>$"+m.getPrice()+"</p></b>");
	out.println("<INPUT TYPE=\"HIDDEN\" NAME=\"loc\" VALUE=\"" +request.getParameter("selectLoc")+"\">");
	out.println("<INPUT TYPE=\"HIDDEN\" NAME=\"ordertype\" VALUE=\"" + request.getParameter("ordertype")+"\">");
	out.println("<INPUT TYPE=\"HIDDEN\" NAME=\"id\" VALUE=\"" + m.getItemid()+"\">");
    //out.printn("<INPUT TYPE=\"HIDDEN\" NAME=\"id\" VALUE=\"" + m.getItemid() + "\">");
	out.println("<button type=\"submit\">Select Item</button>");
	out.println("</form>");
	out.println("</br>");
}

%>
</div>
</section>
<aside class="sidebar" style="float:left">
		<ul>		
			<div ><li align = "center"><a href="index1.jsp" >HOME</a></li></div>
			<div ><li align = "center"><a href="TableBookingForm.jsp">DINE-IN</a></li></div>
			<div ><li align = "center"><a href="location.jsp">LOCATIONS</a></li></div>
			<div ><li align = "center"><a href="#">TRACK ORDER</a></li></div>
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


	