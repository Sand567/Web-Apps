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

public class ProductDispServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {

	String doctype = "<!doctype html>";
	List<Products> outer = new ArrayList<Products>();
	String user;
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	HttpSession session = request.getSession();
	String pcategory = request.getParameter("pcategory");
	user = session.getAttribute("userid").toString();
	Products products = new Products(pcategory);
	outer = MySQLUtilities.getProductsDB(products);
	out.println(doctype+"<html>"+
							"<head>"+
							"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"+
							"<title>Product Display Page</title>"+
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
			out.println("<li><a href = \"CategoryDispServlet\">Categories</a></li>");
		}		
	out.println("</ul>"+
					"</nav>"+
					"<div id = \"body\">"+
					"<section id = \"content\">"+
					"<article>"+
					"<h3 style=\"margin-left: -250px\">"+pcategory+"</h3>"+
					"<table style=\"margin-left: -250px\">"+
					"<tr>"+
					"<th>Name</th>"+
					"<th>Id</th>"+
					"<th>Retailer</th>"+
					"<th>Price</th>"+
					"<th>Condition</th>"+
					"<th>Zipcode</th>"+
					"</tr>");
					
	for(int i=0;i<outer.size();i++) {
	out.println("<tr>"+
				"<td>"+outer.get(i).getName()+"</td>"+
				"<td>"+outer.get(i).getId()+"</td>"+
				"<td>"+outer.get(i).getRetailer()+"</td>"+
				"<td>"+outer.get(i).getPrice()+"</td>"+
				"<td>"+outer.get(i).getCondition()+"</td>"+
				"<td>"+outer.get(i).getZipcode()+"</td>"+
				"<td><form method = \"post\" action =\"/a4/AddToCartServlet\">"+
				"<input type = \"submit\" value = \"ADD TO CART\" />"+
				"<input type = \"hidden\" value = \""+outer.get(i).getId()+"\" name=\"pid\" />"+
				"</form>"+
				"</td>"+
				"<td><form method = \"post\" action = \"/a4/WriteReviewServlet\">"+
				"<input type = \"submit\" value = \"WRITE REVIEW\" />"+
				"<input type = \"hidden\" value = \""+outer.get(i).getId()+"\" name=\"pid\" />"+
				"</form>"+
				"</td>"+
				"<td><form method = \"post\" action =\"/a4/ReadReviewServlet\">"+
				"<input type = \"submit\" value = \"READ REVIEW\" />"+
				"<input type = \"hidden\" value = \""+outer.get(i).getName()+"\" name=\"prodName\" />"+
				"</form>"+
				"</td>"+
				"</tr>");
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