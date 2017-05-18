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

public class UpdateProductServlet extends HttpServlet {
	
	String user;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
	
	
	HttpSession session = request.getSession();
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	String pid = request.getParameter("pid");
	String pcategory = request.getParameter("pcategory");
	String pretailer = request.getParameter("pretailer");
	String pprice = request.getParameter("pprice");
	String pcondition = request.getParameter("pcondition");
	String pzipcode = request.getParameter("pzip");
	String pname = request.getParameter("pname");
	
	Products products = new Products(pname,pid,pretailer,pprice,pcondition,pzipcode,pcategory);
	int i = MySQLUtilities.updateProductDB(products);
	
	if(i > 0) {
		RequestDispatcher rd = request.getRequestDispatcher("UpdateSuccessServlet");
		rd.forward(request,response);
	}
	else {
		out.println("<h3>Sorry Not Successful, No Product to update</h3>");
	}
	}
}
