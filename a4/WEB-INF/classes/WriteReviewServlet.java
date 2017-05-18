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

public class WriteReviewServlet extends HttpServlet {
	
	String user;
	public List<Products> a;
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	Date tdate = new Date();
	MySQLUtilities ms;
	int x = 0;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {

		String doctype = "<!doctype html>";
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		user = session.getAttribute("userid").toString();
		String id = request.getParameter("pid");
		a = MySQLUtilities.getDetails(id);
		String s = dateFormat.format(tdate);
		//for(int k=0;k<a.size();k++) {
		//	System.out.println(a.get(k).getName());
		//}
		out.println(doctype+
					"<html>"+
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
					"input[type=textarea] {"+
					"width:100%;"+
					"padding: 12px 20px;"+
					"margin: 8px 0;"+
					"box-sizing: border-box;"+
					"border: 2px solid black;"+
					"border-radius: 6px;"+
					"}"+
					"</style>"+
					"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"+
					"<title>Write Review Page</title>"+
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
			out.println("<li><a href = \"CategoryDispServlet\">Categories</a></li>");
			out.println("<li style =\"float:right\"><a href = \"LogoutServlet\">Logout</a></li>");
		}
		out.println("</ul>"+
					"</nav>"+
					"<div id = \"body\">"+
					"<section id = \"content\">"+
					"<article>");
							
		for(int i=0;i<a.size();i++) {
			//System.out.println("Inside the 2nd for loop: "+a.get(i).getName());
			//out.println("<h4>"+a.get(i).getName()+"</h4>");
			//String name = a.get(i).getName(); 
			out.println("<form action = \"/a4/WriteReviewToDBServlet\" method = \"post\" >"+
						"<table style=\"margin-left: -260px\" >"+
						"<tr><td>Product Model Name <input type = \"text\" name = \"pmodelName\"  value =\""+ a.get(i).getName() +"\" /></td></tr>"+
						"<tr><td>Product Category <input type = \"text\" name = \"pCategory\"  value =\""+ a.get(i).getCategory() +"\" /></td></tr>"+
						"<tr><td>Product Price <input type = \"text\" name = \"prodPrice\"   value=\""+a.get(i).getPrice()+"\" /></td></tr>"+
						"<tr><td>Retailer Name <input type = \"text\" name = \"retailerName\"   value=\""+a.get(i).getRetailer()+"\" /></td></tr>"+
						"<tr><td>Retailer Zip<input type = \"text\" name = \"retailerZip\"  value=\""+a.get(i).getZipcode()+"\" /></td></tr>"+
						"<tr><td>Retailer City<input type = \"text\" name = \"retailerCity\"/></td></tr>"+
						"<tr><td>Retailer State<input type = \"text\" name = \"retailerState\"/></td></tr>"+
						"<tr><td>Product On Sale<input type = \"text\" name = \"prodonSale\"/></td></tr>"+
						"<tr><td>Manufacturer Name<input type = \"text\" name = \"manuName\"/></td></tr>"+
						"<tr><td>Manufacturer Rebate<input type = \"text\" name = \"manuRebate\" /></td></tr>"+
						"<tr><td>Review Date<input type = \"text\" name = \"reviewDate\" value=\""+s+"\" /></td></tr>"+
						"<tr><td>User id<input type = \"text\" name = \"userName\" /></td></tr>"+
						"<tr><td>User age<center><input type = \"text\" name = \"userAge\"/></td></tr>"+
						"<tr><td>User Gender<center><input type = \"text\" name = \"userGender\"/></tr></td>"+
						"<tr><td>User Occupation<center><input type = \"text\" name = \"userOccupation\"/></td></tr>"+
						"<tr><td>Review<center><textarea style = \"margin-right: 230px; border-radius: 6px; border: 2px solid black;\" rows = \"5\" cols = \"90\" name = \"userReview\"></textarea></td></tr>"+
						"<tr><td>Rating<select name=\"userRating\"><option value=\"1\">1</option><option value =\"2\">2</option><option value=\"3\">3</option><option value=\"4\">4</option><option value=\"5\">5</option></select></td></tr>"+
						"<tr><td><input type = \"submit\" value = \"SUBMIT\" /></td></tr>"+
						"</table>"+
						"</form>");
			a.clear();
		}
		out.println("</article>"+
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