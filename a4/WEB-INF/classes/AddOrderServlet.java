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

public class AddOrderServlet extends HttpServlet {
	
	public MySQLUtilities msu = new MySQLUtilities();
	String user;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {

		int x;
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date todaysdate = new Date();
		Random r = new Random();
		x = r.nextInt(300) + 10;
		String s = dateFormat.format(todaysdate);
		String DelDt = msu.getDeliveryDt(15);
		HttpSession session = request.getSession();
		user = session.getAttribute("userid").toString();
		String doctype = "<!doctype html>";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
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
					"<title>Add Order Page</title>"+
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
					"<h3>Add Order</h3>"+
					"<h2>Fill in the form to Add the Order</h2>"+
					"<form action=\"/a4/AddOrderSuccessServlet\" method=\"post\">"+
					"<table>"+
					"<tr>"+
					"<td>Product Name <input type = \"text\" name = \"pname\"></input></td></tr>"+
					"<tr>"+
					"<td>Order Number <input type = \"text\" name = \"orderNum\" value = "+x+"></input></td></tr>"+
					"<tr>"+
					"<td>Order Date <input type = \"text\" name = \"orderDate\" value = "+s+"></input></td></tr>"+
					"<tr>"+
					"<td>Delivery Date <input type = \"text\" name = \"delDate\" value = "+DelDt+"></input></td></tr>"+
					"<tr>"+
					"<td>Price <input type = \"text\" name = \"orderPrice\"></input></td></tr>"+
					"<tr>"+
					"<td>Card Number <input type = \"text\" name = \"orderCard\"></input></td></tr>"+
					"<tr>"+
					"<td>Zipcode <input type = \"text\" name = \"orderZip\" ></input></td></tr>"+
					"<tr>"+
					"<tr><td><input type = \"submit\" value=\"ADD ORDER\" /></td></tr>"+
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
