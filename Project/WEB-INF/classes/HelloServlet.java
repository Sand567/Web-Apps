import java.io.IOException;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.DBUtilities;

public class HelloServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	         throws IOException, ServletException {
	
	System.out.println("Into HelloServlet");
	
	String action =  request.getParameter("action");
	System.out.println("Into HelloServlet"+request.getParameter("id"));
	System.out.println("Action: "+action);
	}
}
