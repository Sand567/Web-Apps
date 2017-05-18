<%@ page import="java.io.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="java.util.*"%>
<%@ page import = "com.mongodb.*" %>
<%@ page import="com.*"%>

<html>
<body>

<%
try{
	String menuitem = request.getParameter("MenuItem");
	String location = request.getParameter("Location");
	String reviewcomment = request.getParameter("ReviewComment");
	String rating = request.getParameter("Rating");
	String reviewdate = request.getParameter("ReviewDate");
	String username = request.getParameter("Username");
	System.out.println("In Review jsp before");	
	com.MyMongoUtilities.insertReview(menuitem,location,username,reviewcomment,rating,reviewdate);  
	System.out.println("In Review jsp");
	response.sendRedirect("http://localhost:80/Project/ShowReviews.jsp");


	   
          
        //datastore.MongoDBDataStoreUtilities.insertReview(model,category,price,username,retailername,zipcode,retailercity,retailerstate,onsale,manfname,manreb,age,gen,occ,rating,revdate,revtext);           

}catch(Exception e){

}
%>
</body>
</html>