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
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

public class OutputServlet extends HttpServlet {
	
	public static MySQLUtilities msu;
	String user;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			System.out.println("Into Output Servlet");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			HttpSession session = request.getSession();
			user = session.getAttribute("userid").toString();
			String doctype = "<!doctype html>";
			
			String id = request.getAttribute("product").toString();
			System.out.println("Product id: "+id);
			String pname = msu.hmap.get(id).getName();
			String pretailer = msu.hmap.get(id).getRetailer();
			String pprice = msu.hmap.get(id).getPrice();
			String pcondition = msu.hmap.get(id).getCondition();
			String pzipcode = msu.hmap.get(id).getZipcode();
			String pcategory = msu.hmap.get(id).getCategory();
			
			out.println(doctype+"<html>"+
							"<head>"+
							"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"+
							"<title>Product Information</title>"+
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
				out.println("<li class=\"start selected\"><a href=\"NewSessionServlet\">Home</a></li>");
				out.println("<li style =\"float:right\"><a href = \"LogoutServlet\">Logout</a></li>");
				}
			out.println("</ul>"+
					"</nav>"+
					"<div id = \"body\">"+
					"<section id = \"content\">"+
					"<article>"+
					"<h4 style=\"margin-left: -215px; color:black \">Product Information</h4>"+
					"<table style=\"margin-left: -215px\">"+
					"<tr>"+
					"<th>Name</th>"+
					"<th>Retailer</th>"+
					"<th>Price</th>"+
					"<th>Condition</th>"+
					"<th>Zipcode</th>"+
					"<th>Category</th>"+
					"</tr>");
			out.println("<tr><td>"+pname+"</td><td>"+pretailer+"</td><td>"+pprice+"</td><td>"+pcondition+"</td><td>"+pzipcode+"</td><td>"+pcategory+"</td>");
			out.println("<td><form method = \"post\" action = \"/a4/AddToCartServlet\">"+
			"<input type = \"submit\" value = \"ADD TO CART\" />"+
			"<input type = \"hidden\" value = "+id+" name = \"pid\" />"+
			"</form>"+
			"</td>"+
			"<td><form method = \"post\" action = \"/a4/WriteReviewServlet\" />"+
			"<input type = \"submit\" value = \"WRITE REVIEW\" />"+
			"<input type = \"hidden\" value = "+id+" name = \"pid\" />"+
			"</form>"+
			"</td>"+
			"<td><form method = \"post\" action = \"/a4/ReadReviewServlet\" >"+
			"<input type = \"submit\" value = \"READ REVIEW\" />"+
			"<input type = \"hidden\" value = "+pname+" name = \"prodName\" />"+
			"</form>"+
			"</td>"+
			"</tr>");
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