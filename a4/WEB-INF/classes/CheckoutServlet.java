import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.sql.*;
import com.MySQLUtilities;
import com.Products;
import java.util.concurrent.CopyOnWriteArrayList;

public class CheckoutServlet extends HttpServlet {
	
	String user;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
		
		HttpSession session = request.getSession();
		String totalCost = request.getParameter("totalCost");
		//System.out.println(totalCost);
		user = session.getAttribute("userid").toString();
		String doctype = "<!doctype html>";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>"+
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
					"<title>Checkout</title>"+
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
					"<h3>Enter Credit Card Information</h3>"+
					"<form action=\"/a4/OrderConfirmServlet\" method=\"post\">"+
					"<table style=\"margin-left: -260px\">"+
					"<tr>"+
					"<td>Credit/Debit Card <input type = \"text\" name = \"cc\"></input></td></tr>"+
					"<tr>"+
					"<td>Full Name <input type = \"text\" name = \"fname\"></input></td></tr>"+
					"<tr>"+
					"<td>Expiry Date <input type = \"text\" name = \"edate\"></input></td></tr>"+
					"<tr>"+
					"<td>CVV <input type = \"password\" name = \"pprice\"></input></td></tr>"+
					"<tr>"+
					"<td>Zipcode <input type = \"text\" name = \"zipcode\"></input></td></tr>"+
					"<tr><td><input type = \"submit\" value=\"PLACE ORDER\" /></td></tr>"+
					"<tr><td><input type = \"hidden\" value="+totalCost+" name=\"totalCost\" /></td></tr>"+
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