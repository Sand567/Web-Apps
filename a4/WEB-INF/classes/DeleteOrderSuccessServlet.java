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


public class DeleteOrderSuccessServlet extends HttpServlet {
	
	String user;
	Orders order;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {

		int x = 0;
		String orderNum = request.getParameter("orderNum");
		String doctype = "<!doctype html>";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		order = new Orders(orderNum);
		x = MySQLUtilities.deleteOrderDB(order);
		if(x > 0) {

			out.println("<a href = \"SalesmanServlet\">Order Successfully Deleted</a>");
		}
		else {
			out.println("<a href = \"SalesmanServlet\">Deletion Failed</a>");
		}
	}
}