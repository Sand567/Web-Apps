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

public class DeleteProductServlet extends HttpServlet {
	
	String user;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {

	HttpSession session = request.getSession();
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	String pid = request.getParameter("pid");
	String pcategory = request.getParameter("pcategory");
	
	Products products = new Products(pid,pcategory);
	int i = MySQLUtilities.deleteProductDB(products);

	if(i > 0) {
		RequestDispatcher rd = request.getRequestDispatcher("DeleteSuccessServlet");
		rd.forward(request,response);
	}
	else {
		out.println("<h3>Sorry Not Successful, No Product to delete</h3>");
	}
	}
}
