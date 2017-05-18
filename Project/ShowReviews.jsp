<%@ page import="java.io.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="java.util.*"%>
<%@ page import = "com.mongodb.*" %>
<%@ page import="com.*"%>

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
	MongoClient mongo;
		mongo = new MongoClient("localhost", 27017);

	
	
		try{
			
			//String searchModel = "menuitem";
                        //String itemID = request.getParameter("itemIDs");
			
			
			//String searchModelname = itemID;
	
			
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("AmericanSpice");
			
			DBCollection ASReviews = db.getCollection("ASReviews");
			
			// Find and display 
			BasicDBObject searchDB = new BasicDBObject();
			//searchDB.put(searchModel, searchModelname);
                        //System.out.println(searchDB);
			DBCursor cursor = ASReviews.find();
			
			
			System.out.println(cursor);
						
			out.println("<html>");
			out.println("<head> </head>");
			out.println("<body>");
			out.println("<h1> Reviews for AmericanSpice </h1>");
			
			
			if(cursor.count() == 0){
				out.println("No reviews found.");
			}else{
			
				out.println("<table>");	
				String menuitem = "";
				String location = "";
				String reviewcomment = "";
				String rating =  "";
				String reviewdate = "";
                                String username = "";


							
				while (cursor.hasNext()) {
					
					BasicDBObject obj = (BasicDBObject) cursor.next();

								
					out.println("<tr>");
					out.println("<td> MenuItem: </td>");
					menuitem = obj.getString("MenuItem");
					out.println("<td>" +menuitem + "</td>");
					out.println("</tr>");
					
					out.println("<tr>");
					out.println("<td> Location: </td>");
					location = obj.getString("Location");
					out.println("<td>" +location+ "</td>");
					out.println("</tr>");
					
					out.println("<tr>");
					out.println("<td> Username: </td>");
					username = obj.getString("Username");
					out.println("<td>" +username+ "</td>");
					out.println("</tr>");
					
					out.println("<tr>");
					out.println("<td> Rating: </td>");
					rating = obj.getString("Rating");
					out.println("<td>" +rating+ "</td>");
					out.println("</tr>");
					
					out.println("<tr>");
					out.println("<td> ReviewComment: </td>");
					reviewcomment = obj.getString("ReviewComment");
					out.println("<td>" +reviewcomment+ "</td>");
					out.println("</tr>");
					
				        out.println("<tr>");
					out.println("<td> ReviewDate : </td>");
					reviewdate = obj.getString("ReviewDate");
					out.println("<td>" +reviewdate+ "<p></td>");
                                        out.println("</tr>");
					
				       
					
				}	
}
        String revURL =
          "/Project/ReviewForm.jsp";
        // Pass URLs that reference own site through encodeURL.
        revURL = response.encodeURL(revURL);

        out.println
           ("<FORM ACTION=\"" + revURL + "\">\n");
    out.println("<P>\n<CENTER>\n");
           out.println("<INPUT TYPE=\"SUBMIT\" " +
           "VALUE=\"Write a new Review\">\n");
out.println("</CENTER>\n<P>\n</FORM>");

				out.println("</table>");
                                out.println("<br>");
				out.println("</body>");
				out.println("</html>");
			
		} catch (MongoException e) {
				e.printStackTrace();
		}
%>
</div>
</section>
<aside class="sidebar" style="float:left">
		<ul>		
            <div ><li align = "center"><a href="Menu.jsp" ><center>MENU</center></a></li></div>
			<div ><li align = "center"><a href="TableBookingForm.jsp"><center>DINE-IN</center></a></li></div>
			<div ><li align = "center"><a href="location.jsp"><center>LOCATIONS</center></a></li></div>
			<div ><li align = "center"><a href=""><center>TRACK ORDER</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>SHARE EXPERIENCE</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>HELP</center></a></li></div>
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


	