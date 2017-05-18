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

public class StoremanagerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
		String user;
		HttpSession session = request.getSession();
		user = session.getAttribute("userid").toString();
		String doctype = "<!doctype html>";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(doctype+"<html>"+
							"<head>"+
							"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"+
							"<title>Storemanager Login Page</title>"+
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
		if(user != null) {
				out.println("<li><a href=\"add.html\">Add Product</a></li>"+
							"<li><a href=\"delete.html\">Delete Product</a></li>"+
							"<li><a href=\"update.html\">Update Product</a></li>"+
							"<li style = \"float:right\"><a href=\"LogoutServlet\">Logout</a></li>");
			}
		out.println("</ul>"+
					"</nav>"+
					"<div id = \"body\">"+
					"<section id = \"content\">"+
					"<article>"+
					"<center><h4 style=\"margin-left:-200px; color:black;\">Logged In as Store Manager You can now Add/Delete/Update Products</h4></center>"+
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