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
import com.Orders;
import java.util.concurrent.CopyOnWriteArrayList;

public class AddOrderSuccessServlet extends HttpServlet {
	
	Orders order;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {

	String prodName = request.getParameter("pname");
	String orderNum = request.getParameter("orderNum");
	String orderDt = request.getParameter("orderDate");
	String dDate = request.getParameter("delDate");
	String price = request.getParameter("orderPrice");
	String cardNum = request.getParameter("orderCard");
	String zipcode = request.getParameter("orderZip");
	System.out.println(prodName);
	System.out.println(orderNum);
	System.out.println(orderDt);
	System.out.println(dDate);
	System.out.println(price);
	System.out.println(cardNum);
	System.out.println(zipcode);
	String doctype = "<!doctype html>";
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	order = new Orders(prodName,orderNum,orderDt,dDate,price,cardNum,zipcode);
	int i = MySQLUtilities.addOrderDB(order);
	
	if(i > 0) {
		out.println("<a href = \"SalesmanServlet\">Order successfully Added</a>");
	}
	else{
		out.println("<a href = \"SalesmanServlet\">Addtion Failed</a>");
		}
	}
}