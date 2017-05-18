<%@page import="com.*"%>
<%@page import="java.util.*"%>

<%
//for testing setting username 
 session.setAttribute("username", "testuser");

%>


<%

   if(request.getParameter("numItems")!=null){
    ShoppingCart cart1;
    synchronized(session) {
      cart1 = (ShoppingCart)session.getAttribute("shoppingCart"); }            
    //calculate totalPrice
       cart1.setNumOrdered(request.getParameter("itemID"), Integer.parseInt(request.getParameter("numItems")));
   }

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


<%
     ShoppingCart cart;
    synchronized(session) {
      cart = (ShoppingCart)session.getAttribute("shoppingCart");
      // New visitors get a fresh shopping cart.
      // Previous visitors keep using their existing cart.
      if (cart == null) {
        cart = new ShoppingCart();
        session.setAttribute("shoppingCart", cart);
      }
      String itemID = request.getParameter("id");
      if (itemID != null) {
        String numItemsString =
          request.getParameter("numItems");
        if (numItemsString == null) {
          // If request specified an ID but no number,
          // then customers came here via an "Add Item to Cart"
          // button on a catalog page.
          cart.addItem(itemID);
        } else {
          // If request specified an ID and number, then
          // customers came here via an "Update Order" button
          // after changing the number of items in order.
          // Note that specifying a number of 0 results
          // in item being deleted from cart.
          int numItems;
          try {
            numItems = Integer.parseInt(numItemsString);
          } catch(NumberFormatException nfe) {
            numItems = 1;
          }
          cart.setNumOrdered(itemID, numItems);
        }
      }
    }


      List itemsOrdered = cart.getItemsOrdered();
      if (itemsOrdered.size() == 0) {
        out.println("<H2><I>No items in your cart...</I></H2>");
      } else {  
        // If there is at least one item in cart, show table
        // of items ordered.
        out.println
          ("<TABLE BORDER=1 height=\"100px\" style = \"font-family: Century Gothic, Arial, sans-serif\"; ALIGN=\"CENTER\">\n" +
           "<TR>\n" +
           "  <TH>Item Name<TH> Description\n" +
           "  <TH>Unit Cost<TH>Number<TH>Total Cost");
        ItemOrder order;
    
        for(int i=0; i<itemsOrdered.size(); i++) {
          order = (ItemOrder)itemsOrdered.get(i);
          out.println
         ("<TR>\n" +
             "  <TD>" + order.getItem().getIname() + "\n" +
             "  <TD>" + order.getItem().getDescription()+" " + "\n" +
             "  <TD>" +
               (order.getUnitCost()) + "\n" +
             "  <TD>" +
             "<FORM method=\"post\" action=\"viewcart.jsp\">\n" +  // Submit to current URL
             "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\"\n" +
             "       VALUE=\"" + order.getItemID() + "\">\n" +
             "<INPUT TYPE=\"TEXT\" NAME=\"numItems\"\n" +
             "       SIZE=3 VALUE=\"" + 
             order.getNumItems() + "\">\n" +
             "<SMALL>\n" +
             "<INPUT TYPE=\"SUBMIT\"\n "+
             "       VALUE=\"Update Order\">\n" +
             "</SMALL>\n" +
             "</FORM>\n" +
             "  <TD>" +
             (order.getTotalCost()));
        }//for
       
        out.println
          ("</TABLE>\n" +
           "<FORM METHOD =\"post\" ACTION=\"showorder.jsp\">\n" +
           "<BIG><CENTER>\n" +
           "<INPUT TYPE=\"SUBMIT\"\n" +
           "       VALUE=\"Review Order\">\n" +
           "</CENTER></BIG></FORM>");
      }//else
    

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


	