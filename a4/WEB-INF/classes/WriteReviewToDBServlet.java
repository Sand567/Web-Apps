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
import com.MyMongoUtilities;


public class WriteReviewToDBServlet extends HttpServlet {
	
	String user;
	MyMongoUtilities mongo = new MyMongoUtilities();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
		String doctype = "<!doctype html>";
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

	user = session.getAttribute("userid").toString();
	String pmodel = request.getParameter("pmodelName");
	String pcategory = request.getParameter("pCategory");
	String prodPrice = request.getParameter("prodPrice");
	String retailerName = request.getParameter("retailerName");
	String retailerZip = request.getParameter("retailerZip");
	String retailerCity = request.getParameter("retailerCity");
	String retailerState = request.getParameter("retailerState");
	String prodonSale = request.getParameter("prodonSale");
	String manuName = request.getParameter("manuName");
	String manuRebate = request.getParameter("manuRebate");
	String reviewDate = request.getParameter("reviewDate");
	String userName = request.getParameter("userName");
	String userAge = request.getParameter("userAge");
	String userGender = request.getParameter("userGender");
	String userOccupation = request.getParameter("userOccupation");
	String userReview = request.getParameter("userReview");
	String userRating = request.getParameter("userRating");
	
	mongo.insertReview(pmodel,pcategory,prodPrice,retailerName,retailerZip,retailerCity,retailerState,prodonSale,manuName,manuRebate,reviewDate,userName,userAge,userGender,userOccupation,userReview,userRating);
	out.println(doctype+
					"<html>"+
					"<head>"+
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
					"<article>"+
					"<h4><strong>Review Submitted Successfully</strong></h4>");
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

