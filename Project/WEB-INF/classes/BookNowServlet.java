	import java.io.IOException;
	import java.util.Date;

	import javax.servlet.*;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.*;

	import com.DBUtilities;
	
	public class BookNowServlet extends HttpServlet{
		
		 public void doGet(HttpServletRequest request, HttpServletResponse response)
		         throws IOException, ServletException {			
			 
			 String Tableno = (String) request.getParameter("tno");
			 String date = (String) request.getParameter("date");
			 String slot = (String)request.getParameter("time");
			 String loc = (String)request.getParameter("location");
			 String tsize = (String)request.getParameter("size");
			
			 System.out.println("booking Date* "+date);
			 System.out.println("timeslot* "+ slot);
			 System.out.println("location* "+loc);
			 System.out.println("tablesize* "+tsize);
			 System.out.println("tableno* "+Tableno);
			 HttpSession session = request.getSession();
			 String userid=null;
				synchronized(session) {
				userid = (String) session.getAttribute("fname");
					}				
			 DBUtilities.bookTable(userid,loc,date,slot,tsize,Tableno);
			 request.setAttribute("bdate",date);
			 request.setAttribute("tableNo",Tableno);
			 request.setAttribute("location",loc);
			 request.setAttribute("timeslot",slot);
			 request.setAttribute("tablesize",tsize);
			 request.getRequestDispatcher("/TableBookingSuccess.jsp").forward(request, response);


		 }
		
		
		
	}

