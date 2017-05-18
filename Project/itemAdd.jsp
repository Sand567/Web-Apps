<%@ page import ="java.sql.*" %>
<%@ page import ="java.io.*" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import ="com.Menu" %>
<%@ page import ="com.DBUtilities" %>

<%
    String name = request.getParameter("itname");
	String num = request.getParameter("itnumber");
	int price = Integer.parseInt(request.getParameter("itprice"));
	String description = request.getParameter("description");
	String category= request.getParameter("category");
	String image= request.getParameter("image");
//String role = "Customer";
	Menu  menu =new Menu(num,name,description,price,image,category);

 int j= DBUtilities.addItm(menu);	
	if (j>0)
{
//out.println("inserted successfully");
RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
rd.forward(request,response);
}
else
{
//out.println("unsuccessfull");
}
	
%>