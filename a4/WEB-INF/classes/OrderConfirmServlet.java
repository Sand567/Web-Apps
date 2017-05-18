import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.MySQLUtilities;
import com.Products;
import com.Orders;


public class OrderConfirmServlet extends HttpServlet {
	
	public static MySQLUtilities msu = new MySQLUtilities();
	String user;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {

	Orders order;
	int x=1000;
	DateFormat dateFormat;
	Date todaysdate;
	int j =0;
	Random r;
	String user;
	HttpSession session = request.getSession();
	user = session.getAttribute("userid").toString();
	String doctype = "<!doctype html>";
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<html>"+
					"<head>"+
					"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"+
					"<title>Order Confirmed</title>"+
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
					"<article>");

	String totalCost = request.getParameter("totalCost");
	System.out.println(totalCost);
	String zipCode = request.getParameter("zipcode");
	String cc = request.getParameter("cc");
	
	for(int i=0;i<msu.obj.size();i++) {
		dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		todaysdate = new Date();
		r = new Random();
		x = r.nextInt(300) + 10;
		String s = dateFormat.format(todaysdate);
		String DelDt = msu.getDeliveryDt(15);
		order = new Orders(msu.obj.get(i).getName(),Integer.toString(x),s, DelDt,totalCost,cc,zipCode);
		
		j = msu.confirmedOrder(order);

		out.println("<table>"+
				"<tr><td><h2>Product: "+msu.obj.get(i).getName()+"</h2></td></tr>"+
				"<tr><td><strong>Order Number: "+Integer.toString(x)+"</strong></td></tr>"+
				"<tr><td><strong>Order Date: "+s+"</strong></td></tr>"+
				"<tr><td><strong>Delivery Date: "+DelDt+"</strong></td></tr>"+
				"</table>");
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