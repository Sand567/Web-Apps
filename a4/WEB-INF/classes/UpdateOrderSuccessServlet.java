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

public class UpdateOrderSuccessServlet extends HttpServlet {
	
	Orders order;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {

	int x = 0;
	String doctype = "<!doctype html>";
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	String orderNum = request.getParameter("orderNum");
	String prodName = request.getParameter("pname");
	String price = request.getParameter("orderPrice");
	String zipcode = request.getParameter("orderZip");
	
	order = new Orders(orderNum,prodName,price,zipcode);
	x = MySQLUtilities.updateOrderDB(order);
	if(x > 0) {
		out.println("<a href = \"SalesmanServlet\">Order Updated Successfully</a>");
	}else {
		out.println("<a href = \"SalesmanServlet\">updation failed</a>");
		}
	}
}
