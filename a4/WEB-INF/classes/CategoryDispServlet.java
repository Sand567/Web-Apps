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

public class CategoryDispServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
		String doctype = "<!doctype html>";
		String user;
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		user = session.getAttribute("userid").toString();
		out.println(doctype+"<html>"+
							"<head>"+
							"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"+
							"<title>Category Display Page</title>"+
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
					"<h3>Choose Category to view</h3>"+
					"<form method = \"post\" action = \"/a4/ProductDispServlet\">"+
					"<table>"+
					"<tr>"+
					"<td>Category <select name=\"pcategory\"><option value=\"Smartphones\">Smartphones</option><option value = \"Laptops\">Laptops<option value= \"Tablets\">Tablets</option><option value=\"TV\">TV</option></select></td></tr>"+
					"<tr><td><input type = \"submit\" value=\"VIEW\" width=\"20\" height=\"20\" /></td></tr>"+
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