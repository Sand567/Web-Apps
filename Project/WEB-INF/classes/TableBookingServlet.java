import java.io.IOException;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.DBUtilities;

public class TableBookingServlet extends HttpServlet{

	
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	         throws IOException, ServletException {
	 
	 
		System.out.println("Into Servlet");
		 String bookingDate = request.getParameter("date");
		 String timeSlot = request.getParameter("timeSlot");
		 String location = request.getParameter("selectLoc");
		 String tableSize = request.getParameter("tableSize");
		 
		 System.out.println("booking Date "+bookingDate);
		 System.out.println("timeslot "+ timeSlot);
		 System.out.println("location "+location);
		 System.out.println("tablesize "+tableSize);
				
		 
		 int res = DBUtilities.getFreeTableToBook( location , bookingDate ,timeSlot,tableSize);
		 System.out.println("result table num = "+res);
		 
		 request.setAttribute("tabenumber", res);
		 request.setAttribute("date",bookingDate);
		 request.setAttribute("timeSlot",timeSlot);
		 request.setAttribute("selectLoc",location);
		 request.setAttribute("tableSize",tableSize);
		 request.getRequestDispatcher("/TableBookingForm.jsp").forward(request, response);

		 
		 
	 }
	
	
	
}
