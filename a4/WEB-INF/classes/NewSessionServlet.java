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


public class NewSessionServlet extends HttpServlet {
	
	public static MySQLUtilities ms;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
		ms = new MySQLUtilities();
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user;
		user = session.getAttribute("userid").toString();
		HashMap<String,Products> selectedProducts = new HashMap<String,Products>();
		String doctype = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 \" + \"Transitional//EN\">";
		out.println(doctype+"<html>"+
							"<head>"+
							"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"+
							"<title>Hello Page</title>"+
							"<link rel=\"stylesheet\" href=\"styles.css\" type=\"text/css\" />"+
							"<script src=\"searchScript.js\">"+
							"</script>"+
							"</head>"+
							"<body onload = \"init()\">"+
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
			out.println("<li><input type=\"text\" name = \"searchId\" id = \"searchId\" onkeyup = \"doCompletion()\" size = \"50\" placeholder = \"SEARCH PRODUCT\" height = \"60\" style = \"margin-top:20px; margin-left:35px; height:30px\" />");
			out.println("<div id= \"auto-row\">");
			out.println("<table id = \"complete-table\">");
			out.println("</table>");
			out.println("</div>");
			out.println("</li>");
			out.println("<li style =\"float:right\"><a href = \"LogoutServlet\">Logout</a></li>");
		}
		out.println("</ul>"+
					"</nav>"+
					"<marquee scrollamount = \"20\" direction = \"left\" behavior = \"alternate\" loop = \"10000\">"+
					"<img src= \"images/laptop1.jpg\" width = \"960\" height = \"500\"  alt=\"Laptop\" />"+
					"<img src=\"images/Smartphone3.jpg\" width = \"960\" height = \"500\"  alt=\"Smartphone\" />"+
					"<img src=\"images/Tablet1.jpg\" width = \"960\" height = \"500\"  alt=\"Tablet\" />"+
					"<img src=\"images/TV1.jpg\" width = \"960\" height = \"500\"  alt=\"TV\" />"+
					"</marquee>"+
					"<div id = \"body\">"+
					"<section id = \"content\">"+
					"<article>"+
					"<h2>BestDeal</h2>"+
					"<div class=\"article-info\">Posted on <time datetime=\"2016-10-06\">06 Oct</time> by Sandeep"+
					"</div>"+
					"<p style = \"color:black\">Welcome to BestDeal, the best ongoing deals at the market. This Website gives you the best offers and deals you will find in the internet and in all of the United States .This gives you a segregation of all the products and its related accessories along with the details of each product and accessory from all over the world."+
					"</p>"+
					"<h2>Deals</h2>"+"<br>");
		String line = null;
		ms.fetchProducts();
		HashMap<String,Products> productMap = ms.getFetchedProducts();
		for(Map.Entry<String, Products> entry : productMap.entrySet()) {
			if(selectedProducts.size()<2 && !selectedProducts.containsValue(entry.getValue().getName())) {
				BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\Sandeep\\Anaconda3\\DealMatches.txt")));
				line = br.readLine();
				if(line == null) {
					out.println("<h4 style=\"color:black\">No Offers Found</h4>");
					break;
				}else {
					do {
						if(line.contains(entry.getValue().getName())) {
							out.println("<h4 style= \"color:black\"><b>"+line+"</b></h4>");
							out.println("<br>");
							selectedProducts.put(entry.getKey(),entry.getValue());
							break;
						}
					}while((line = br.readLine())!= null);					
				}
			br.close();
			}
		}
		out.println("<h2>Deal Matches</h2>"+"<br>");
		if(selectedProducts.size() == 0) {
			out.println("<h4 style =\"color:black\">No Deal Matches</h4>");
			}
		else {
			for(Map.Entry<String,Products> m : selectedProducts.entrySet()) {
						out.println("<table>"+
						"<tr>"+
						"<th style = \"background-color:#224953\">Name</th>"+
						"<th style = \"background-color:#224953\">Id</th>"+
						"<th style = \"background-color:#224953\">Retailer</th>"+
						"<th style = \"background-color:#224953\">Price</th>"+
						"<th style = \"background-color:#224953\">Condition</th>"+
						"<th style = \"background-color:#224953\">Zipcode</th>"+"</tr>"+
						"<tr>"+
						"<td style = \"color:black\"><b>"+m.getValue().getName()+"</b></td>"+
						"<td style = \"color:black\"><b>"+m.getKey()+"</b></td>"+
						"<td style = \"color:black\"><b>"+m.getValue().getRetailer()+"</b></td>"+
						"<td style = \"color:black\"><b>"+m.getValue().getPrice()+"</b></td>"+
						"<td style = \"color:black\"><b>"+m.getValue().getCondition()+"</b></td>"+
						"<td style = \"color:black\"><b>"+m.getValue().getZipcode()+"</b></td>"+
						"</tr>"+
						"<tr>"+	
						"<td><form method = \"post\" action = \"/a4/WriteReviewServlet\">"+
						"<input type = \"submit\" style = \"background-color: #224953; color: white\" value = \"WRITE REVIEW\" />"+
						"<input type = \"hidden\" value = "+m.getKey()+" name=\"pid\" width = \"50px\"  />"+
						"</form>"+
						"</td>"+
						"<td><form method = \"post\" action =\"/a4/ReadReviewServlet\">"+
						"<input type = \"submit\" style = \"background-color: #224953; color: white\" value = \"READ REVIEW\" />"+
						"<input type = \"hidden\" value = "+m.getValue().getName()+" name=\"prodName\" width = \"50px\" />"+
						"</form>"+
						"</td>"+
						"<td><form method = \"post\" action =\"/a4/AddToCartServlet\">"+
						"<input type = \"submit\" style = \"background-color: #224953; color: white\" value = \"ADD TO CART\" />"+
						"<input type = \"hidden\" value = "+m.getKey()+" name=\"pid\" width = \"50px\" />"+
						"</form>"+
						"</td>"+
						"</tr>"+
						"</table>"+"<br>");
			}
		}
		out.println("</article>"+
					"</section>"+
					"<aside class=\"sidebar\">"+
					"<ul>"+
					"<li>"+
					"<h4>Categories</h4>"+
					"<ul>"+
					"<li><a href=\"CategoryDispServlet\">Products</a></li>"+
					"<li><a href=\"TrendingServlet\">Trending</a><li>"+
					"</ul>"+
					"</li>"+
					"<li>"+
					"<h4>About us</h4>"+
					"<ul>"+
					"<li class=\"text\">"+
					"<p style=\"margin: 0;\">This website truly is designed for those people who is a frequent shopper </p>"+
					"</li>"+
					"</ul>"+
					"</li>"+
					"</aside>"+
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