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

public class SalesmanServlet extends HttpServlet {
	
	public static MySQLUtilities msu = new MySQLUtilities();
	String user;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
			
		System.out.println("Entered Salesman page");
		HttpSession session = request.getSession();
		user = session.getAttribute("userid").toString();
		String doctype = "<!doctype html>";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(doctype+"<html>"+
					"<head>"+
					"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"+
					"<title>Salesman Login Page</title>"+
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
			out.println("<li><a href=\"AddOrderServlet\">Add Order</a></li>");
			out.println("<li><a href=\"DeleteOrderServlet\">Delete Order</a></li>");
			out.println("<li><a href=\"UpdateOrderServlet\">Update Order</a></li>");
			out.println("<li><a href=\"register.html\">Create Customer Accounts</a></li>");
			out.println("<li style =\"float:right\"><a href = \"LogoutServlet\">Logout</a></li>");
		}
		out.println("</ul>"+
					"</nav>"+
					"<br>"+
					"<center><h4>Logged In as Salesman You can now Add/Delete/Update Orders</h4></center>"+
					"<br>"+
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
