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

public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
			
			String doctype = "<!doctype html>";
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			session.removeAttribute("userid");
			session.invalidate();
			
			if(session == null)
			{
				response.sendRedirect("/a4/LogoutRedirectServlet");
			}
			out.println(doctype+
						"<html>"+
						"<head>"+
						"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />"+
						"<title>Home Page</title>"+
						"<link rel=\"stylesheet\" href=\"styles.css\" type=\"text/css\" />"+
						"</head>"+
						"<body>"+
						"<div id=\"container\">"+
						"<header>"+
						"<h1>Best<span>Deal</span></a></h1>"+
						"<h2>The best ever deal you will ever get!</h2>"+
						"</header>"+
						"<nav>"+
						"<ul>"+
						"<li class=\"start selected\"><a href=\"index.jsp\">Home</a></li>"+
						"<li><a href=\"newsite.jsp\">Help</a></li>"+
						"<li style=\"float:right\";><a href=\"register.jsp\">Sign-Up</a></li>"+
						"<li style=\"float:right\";><a href=\"login.jsp\">Login</a></li>"+
						"</ul>"+
						"</nav>"+
						"<div id=\"body\">"+
						"<section id=\"content\">"+
						"<article>");
			response.sendRedirect("/a4/LogoutRedirectServlet");
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
      
