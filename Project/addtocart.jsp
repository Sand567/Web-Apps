<%@page import="com.*"%>

<%@page import="java.util.List"%>
<%@page import="java.io.*"%>
<%
System.out.println("In add to cart Servlet!! jap");

	System.out.println("id !"+request.getParameter("id"));	
  
	  
	  
    ShoppingCart cart;
    synchronized(session) {
      cart = (ShoppingCart)session.getAttribute("shoppingCart");
      if (cart == null) {
        cart = new ShoppingCart();
        session.setAttribute("shoppingCart", cart);
      }
      String itemID = request.getParameter("id");
      System.out.println(" id!!! "+itemID);
      if (itemID != null) {
      String numItemsString =null;
        try{ 
          numItemsString =
          request.getParameter("numItems");
          }
          catch(Exception e) {

          }
        if (numItemsString == null) {
        	System.out.println(" id!!! ***"+itemID);
          cart.addItem(itemID);
        } else {
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


RequestDispatcher dispatch=request.getRequestDispatcher("Menu.jsp");
dispatch.forward(request,response);
    
  

    %>



