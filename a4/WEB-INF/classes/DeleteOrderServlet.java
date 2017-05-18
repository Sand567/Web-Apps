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


public class DeleteOrderServlet extends HttpServlet {
	
	public static MySQLUtilities msu = new MySQLUtilities();
	String user;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
		HttpSession session = request.getSession();
		user = session.getAttribute("userid").toString();
		String doctype = "<!doctype html>";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		user = session.getAttribute("userid").toString();
		out.println(doctype+"<html>"+
					"<head>"+
					"<style>"+
					"input[type=text] {"+
					"width:100%;"+
					"padding: 12px 20px;"+
					"margin: 8px 0;"+
					"box-sizing: border-box;"+
					"border: 2px solid black;"+
					"border-radius: 6px;"+
					"}"+
					"</style>"+
					"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"+
					"<title>Delete Order Page</title>"+
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
			out.println("<li style =\"float:right\"><a href = \"LogoutServlet\">Logout</a></li>");
		}
		out.println("</ul>"+
					"</nav>"+
					"<div id = \"body\">"+
					"<section id = \"content\">"+
					"<article>"+
					"<h3>Delete Order</h3>"+
					"<h2>Enter the Order Number to delete Order</h2>"+
					"<form action=\"/a4/DeleteOrderSuccessServlet\" method=\"post\">"+
					"<table>"+
					"<tr>"+
					"<td>Order Number<input type = \"text\" name = \"orderNum\"></input></td></tr>"+
					"<tr><td><input type = \"submit\" value=\"DELETE ORDER\" /></td></tr>"+
					"</table>"+
					"</form>"+
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