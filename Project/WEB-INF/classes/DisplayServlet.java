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
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import com.DBUtilities;
import com.MenuItem;
import com.Order;
import com.Location;
import com.Users;

public class DisplayServlet extends HttpServlet {
	
	public static DBUtilities dbu;
	String user;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			System.out.println("Into Output Servlet");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			HttpSession session = request.getSession();
			String doctype = "<!doctype html>";
			
			String id = request.getAttribute("menuitem").toString();
			System.out.println("MenuItem id: "+id);
			String iname = dbu.hmap.get(id).getIname();
			String description = dbu.hmap.get(id).getDescription();
			int price = dbu.hmap.get(id).getPrice();
			String image = dbu.hmap.get(id).getImage();
			String category = dbu.hmap.get(id).getCategory();
			
			out.println(doctype+"<html>"+
								"<head>"+
								"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />"+
								"<title>"+iname+" Page</title>"+
								"<link rel=\"stylesheet\" href=\"allstyle.css\" type=\"text/css\" />"+
								"</head>"+
								"<body>"+
								"<div class=\"container\">"+
								"<header>"+
								"<h1>American <span>Spice</span></h1>"+
								"<h2>The taste of America !</h2>"+
								"<img src = \"images/thumb.jpeg\" alt = \"Restaurant\" />"+
								"</header>"+
								"</div>"+
								"<nav>"+
								"<ul>"+
								"<li style=\"float:right\";><a href=\"index.jsp\">Logout</a></li>"+
								"<li style=\"float:right\";><a href=\"viewcart.jsp\">ViewCart</a></li>"+
								"</ul>"+
								"</nav>"+
								"<section id = \"content\" style=\"min-height:500px\">"+
								"<div align=\"center\" style = \"font-family: Century Gothic, Arial, sans-serif\";>");
			out.println("<form method=\"get\" action=\"addtocart.jsp\">");
			out.println("<b><p>"+iname+"</p></b>");
			out.println("<img  style=\"width:200px;height:200px;border-radius:50%\" src =\""+image+"\">");
			out.println("<div float=\"center\" style=\"max-width:200px\">");
			out.println("<small><i><p>"+description+"</p></i></small>");
			out.println("</div>");
			out.println("<b><p>$"+price+"</p></b>");
			out.println("<INPUT TYPE=\"HIDDEN\" NAME=\"loc\" VALUE=\"" +request.getParameter("selectLoc")+"\">");
			out.println("<INPUT TYPE=\"HIDDEN\" NAME=\"ordertype\" VALUE=\"" + request.getParameter("ordertype")+"\">");
			out.println("<INPUT TYPE=\"HIDDEN\" NAME=\"id\" VALUE=\"" + dbu.hmap.get(id).getItemid()+"\">");
			out.println("<button type=\"submit\">Select Item</button>");
			out.println("</form>");
			out.println("</br>");
			out.println("</div>"+
						"</section>"+
						"<aside class=\"sidebar\" style=\"float:left\">"+
						"<ul>"+
						"<div ><li align = \"center\"><a href=\"index1.jsp\" >HOME</a></li></div>"+
						"<div ><li align = \"center\"><a href=\"TableBookingForm.jsp\">DINE-IN</a></li></div>"+
						"<div ><li align = \"center\"><a href=\"location.jsp\">LOCATIONS</a></li></div>"+
						"<div ><li align = \"center\"><a href=\"#\">TRACK ORDER</a></li></div>"+
						"<div ><li align = \"center\"><a href=\"#\">SHARE EXPERIENCE</a></li></div>"+
						"<div ><li align = \"center\"><a href=\"#\">HELP</a></li></div>"+
						"</ul>"+
						"</aside>"+
						"<div class=\"clear\"></div>"+
						"<footer>"+
						"<div class=\"footer-bottom\">"+
						"<center><p><strong>&copy; American Spice 2016.</strong> <a href=\"#\">www.AmericanSpice.com</a></p></center>"+
						"</div>"+
						"</footer>"+
						"</body>"+
						"</html>");
		}
		
}