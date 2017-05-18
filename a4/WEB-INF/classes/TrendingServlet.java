import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.MySQLUtilities;
import com.Products;
import com.Orders;
import com.MyMongoUtilities;

public class TrendingServlet extends HttpServlet {
	
	String user;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {		
		
		List<String> zip = MyMongoUtilities.getZip();
		//List<String> sold = MySQLDataStoreUtilities.getSoldProducts();
		//List<String> mostLiked = MyMongoUtilities.topFiveLikedProducts();
		HttpSession session = request.getSession();
		user = session.getAttribute("userid").toString();
		String doctype = "<!doctype html>";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>"+
					"<head>"+
					"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"+
					"<title>Order Confirmed</title>"+
					"<link rel=\"stylesheet\" href=\"styles.css\" type=\"text/css\" />"+
					"</head>"+
					"<body>"+
					"<div id = \"container\">"+
					"<header>"+
					"<h1>Best<span>Deal</span></h1>"+
					"<h2>The best ever deal you will ever get!</h2>"+
					"</header>"+
					"<nav>"+
					"<ul>"+
					"<li class=\"start selected\"><a href=\"NewSessionServlet\">Home</a></li>");
		if (user != null) {
			out.println("<li style = \"float:right;\"><a href =\"#\">Hello, "+user+"</a></li>");
			out.println("<li style =\"float:right\"><a href = \"LogoutServlet\">Logout</a></li>");
		}
		out.println("</ul>"+
					"</nav>"+
					"<div id = \"body\">"+
					"<section id = \"content\">"+
					"<article>"+
					"<h3>Top 5 Zip Codes</h3>"+
					"<table>"+
					"<thead><td><strong>Zip Code</strong></td><td><strong>Number Of Products</strong></td></thead>");		 
					

for (String entry : zip) {
	String[] values = entry.split(",");
	out.println("<tr><td>"+values[0]+"</td><td>"+values[1]+"</td></tr>");
}
		out.println("</table>"+
					"</article>"+
					"</section>"+
					"<div>"+
					"<div class=\"clear\"></div>"+
					"</div>"+
					"<footer>"+
					"<div class = \"footer-bottom\">"+
					"<p><a href=\"http:BestDeal.com\">Best Deal 2016</a></p>"+
					"</div>"+
					"</footer>"+
					"</div>"+
					"</body>"+
					"</html>");
		
	}
}