import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Authenticate;

public class NewLoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	Authenticate auth = new Authenticate();

	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	System.out.println("userid");
		
	if (userid.equals("Storemanager") && password.equals("store")) {
		HttpSession session = request.getSession();
		session.setAttribute("userid",userid);
		response.sendRedirect("/a4/StoremanagerServlet");
	}
	else if (userid.equals("Salesman") && password.equals("sales")) {
		HttpSession session = request.getSession();
		session.setAttribute("userid",userid);
		response.sendRedirect("/a4/SalesmanServlet");
	}
	else if(auth.check(userid,password)) {
			
		HttpSession session = request.getSession();
		session.setAttribute("userid",userid);
		RequestDispatcher rd = request.getRequestDispatcher("/NewSessionServlet");
		rd.forward(request,response);
	}
		else {
	out.println("<a href = \"index.html\"><strong><h4>Incorrect Username or Password. Please click on the link to go back to Home Page</h4></strong></a>");
		}
	}
}