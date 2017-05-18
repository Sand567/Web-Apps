import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.MySQLUtilities;
import com.Products;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.Orders;
import com.MyMongoUtilities;

public class ReadReviewServlet extends HttpServlet {

		String user;		
		List<Map<String,String>> newList = new ArrayList<Map<String,String>>();
		MyMongoUtilities mn = new MyMongoUtilities();
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, java.io.IOException {

			String prodName = request.getParameter("prodName");
			System.out.println(prodName);
			String doctype = "<!doctype html>";
			HttpSession session = request.getSession();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			user = session.getAttribute("userid").toString();
			
			
			newList = mn.getReviews(prodName);
			//for (int i=0;i<newList.size();i++) {
				//System.out.println(newList.get(i));
			out.println(doctype+
					"<html>"+
					"<head>"+
					"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"+
					"<title>Read Review Page</title>"+
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
					"<li class=\"start selected\"><a href=\"index.html\">Home</a></li>");
		if (user != null) {						
			out.println("<li style = \"float:right;\"><a href =\"#\">Hello, "+user+"</a></li>");
			out.println("<li><a href = \"CategoryDispServlet\">Categories</a></li>");
			out.println("<li style =\"float:right\"><a href = \"LogoutServlet\">Logout</a></li>");
		}
		out.println("</ul>"+
					"</nav>"+
					"<div id = \"body\">"+
					"<section id = \"content\">"+
					"<article style=\"margin-left:-200px\">"+
					"<h2>"+prodName+"</h2><br>"+
					"<table>");
		for(Map<String,String> entry : newList) {
			for(String key:entry.keySet()) {
				out.println("<tr><td><h4 style=\"color:black\"><strong>"+key+"</strong></h4></td>"+"<td><h4 style=\"color:black\"><center><strong>"+entry.get(key)+"</strong></center></h4></td></tr>");
				}
			}
		out.println("</table>"+
				"</article>"+
				"</section>"+
				"</div>"+
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
		