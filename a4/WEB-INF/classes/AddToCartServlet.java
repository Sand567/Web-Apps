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


public class AddToCartServlet extends HttpServlet {
	
	static double totalCost = 0;
	static double cost = 0;
	public List<Products> prod = new CopyOnWriteArrayList<Products>();
	String user;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
	
		
	String doctype = "<!doctype html>";

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	HttpSession session = request.getSession();
	user = session.getAttribute("userid").toString();
	MySQLUtilities ms;
	session = request.getSession();
	ms = (MySQLUtilities) session.getAttribute("cart");
	if(ms == null) {
		ms = new MySQLUtilities();
		session.setAttribute("cart",ms);
	}
	String pid = request.getParameter("pid");
	prod = ms.addtoCart(pid);
	session.setAttribute("cart", ms);
	out.println(doctype+"<html>"+
							"<head>"+
							"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"+
							"<title>Add To Cart</title>"+
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
			out.println("<li class=\"start selected\"><a href=\"index.html\">Home</a></li>");
			out.println("<li style = \"float:right;\"><a href =\"#\">Hello, "+user+"</a></li>");
			out.println("<li style =\"float:right\"><a href = \"LogoutServlet\">Logout</a></li>");
			out.println("<li><a href = \"CategoryDispServlet\">Categories</a></li>");
		}		
	out.println("</ul>"+
					"</nav>"+
					"<div id = \"body\">"+
					"<section id = \"content\">"+
					"<article>"+
					"<h3 style=\"margin-left: -215px\">Cart Details</h3>"+
					"<table style=\"margin-left: -215px\">"+
					"<tr>"+
					"<th>Name</th>"+
					"<th>Id</th>"+
					"<th>Retailer</th>"+
					"<th>Price</th>"+
					"<th>Condition</th>"+
					"<th>Zipcode</th>"+
					"<th>Category></th>"+
					"</tr>");
	cost=0; 
	for(int i=0;i<prod.size();i++) {
	out.println("<tr>"+"<td>"+prod.get(i).getName()+"</td>"+"<td>"+prod.get(i).getId()+"</td>"+"<td>"+prod.get(i).getRetailer()+"</td>"+
				"<td>"+prod.get(i).getPrice()+"</td>"+"<td>"+prod.get(i).getCondition()+"</td>"+"<td>"+prod.get(i).getZipcode()+"</td>"+
				"<td>"+prod.get(i).getCategory()+"</td>"+
				"<td><form method = \"post\" action =\"/a4/DeleteFromCartServlet\">"+
				"<input type = \"submit\" value = \"DELETE FROM CART\" />"+
				"<input type = \"hidden\" value = "+prod.get(i).getId()+" name=\"pid\" />"+
				"</form>"+
				"</td>"+
				"</tr>"+
				"<tr>");
				
	String s = prod.get(i).getPrice();
	cost += Double.parseDouble(s);
	}
	totalCost = cost;
	out.println("</table>"+
				"</article>"+
				"<label><strong>Total cost=  "+totalCost+"</strong></label>"+
				"<form method = \"post\" action =\"/a4/CheckoutServlet\">"+
				"<input type = \"submit\" value = \"CHECK OUT\" />"+
				"<input type = \"hidden\" value = "+totalCost+" name=\"totalCost\" />"+
				"</form>"+
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
	
	String doctype = "<!doctype html>";

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	HttpSession session = request.getSession();
	user = session.getAttribute("userid").toString();
	MySQLUtilities ms;
	session = request.getSession();
	ms = (MySQLUtilities) session.getAttribute("cart");
	if(ms == null) {
		ms = new MySQLUtilities();
		session.setAttribute("cart",ms);
	}
	String pid = request.getParameter("pid");
	prod = ms.addtoCart(pid);
	session.setAttribute("cart", ms);
	out.println(doctype+"<html>"+
							"<head>"+
							"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"+
							"<title>Add To Cart</title>"+
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
			out.println("<li class=\"start selected\"><a href=\"index.html\">Home</a></li>");
			out.println("<li style = \"float:right;\"><a href =\"#\">Hello, "+user+"</a></li>");
			out.println("<li style =\"float:right\"><a href = \"LogoutServlet\">Logout</a></li>");
			out.println("<li><a href = \"CategoryDispServlet\">Categories</a></li>");
		}		
	out.println("</ul>"+
					"</nav>"+
					"<div id = \"body\">"+
					"<section id = \"content\">"+
					"<article>"+
					"<h3 style=\"margin-left: -215px\">Cart Details</h3>"+
					"<table style=\"margin-left: -215px\">"+
					"<tr>"+
					"<th>Name</th>"+
					"<th>Id</th>"+
					"<th>Retailer</th>"+
					"<th>Price</th>"+
					"<th>Condition</th>"+
					"<th>Zipcode</th>"+
					"<th>Category></th>"+
					"</tr>");
	cost=0; 
	for(int i=0;i<prod.size();i++) {
	out.println("<tr>"+"<td>"+prod.get(i).getName()+"</td>"+"<td>"+prod.get(i).getId()+"</td>"+"<td>"+prod.get(i).getRetailer()+"</td>"+
				"<td>"+prod.get(i).getPrice()+"</td>"+"<td>"+prod.get(i).getCondition()+"</td>"+"<td>"+prod.get(i).getZipcode()+"</td>"+
				"<td>"+prod.get(i).getCategory()+"</td>"+
				"<td><form method = \"post\" action =\"/a4/DeleteFromCartServlet\">"+
				"<input type = \"submit\" value = \"DELETE FROM CART\" />"+
				"<input type = \"hidden\" value = "+prod.get(i).getId()+" name=\"pid\" />"+
				"</form>"+
				"</td>"+
				"</tr>"+
				"<tr>");
				
	String s = prod.get(i).getPrice();
	cost += Double.parseDouble(s);
	}
	totalCost = cost;
	out.println("</table>"+
				"</article>"+
				"<label><strong>Total cost=  "+totalCost+"</strong></label>"+
				"<form method = \"post\" action =\"/a4/CheckoutServlet\">"+
				"<input type = \"submit\" value = \"CHECK OUT\" />"+
				"<input type = \"hidden\" value = "+totalCost+" name=\"totalCost\" />"+
				"</form>"+
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


