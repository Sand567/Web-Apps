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


public class DeleteFromCartServlet extends HttpServlet {
	
		
	static double totalCost = 0;
	public List<Products> prod = new CopyOnWriteArrayList<Products>();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
	


	MySQLUtilities ms;
	HttpSession session = request.getSession();
	ms = (MySQLUtilities) session.getAttribute("cart");
	String pid = request.getParameter("pid");
	prod = ms.deleteFromCart(pid);
	session.setAttribute("cart", ms);
	ms = (MySQLUtilities) session.getAttribute("cart");
	response.sendRedirect("/a4/AddToCartServlet");
	}
}
