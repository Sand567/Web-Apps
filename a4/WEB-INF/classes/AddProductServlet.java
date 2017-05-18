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

public class AddProductServlet extends HttpServlet {
	
	String user;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
	HttpSession session = request.getSession();
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	String pname = request.getParameter("pname");
	String pid = request.getParameter("pid");
	String pretailer = request.getParameter("pretailer");
	String pprice = request.getParameter("pprice");
	String pcondition = request.getParameter("pcondition");
	String pzip = request.getParameter("pzip");
	String pcategory = request.getParameter("pcategory");
	
	Products products = new Products(pname,pid,pretailer,pprice,pcondition,pzip,pcategory);
	int i = MySQLUtilities.addProductDB(products);
	System.out.println("outsd if");
	if(i>0) {
			System.out.println("inside if");

		RequestDispatcher rd = request.getRequestDispatcher("AddSuccessServlet");
		rd.forward(request,response);
	}
	else {
		out.println("<h3>Sorry Not Successful</h3>");		
	}
	}
}