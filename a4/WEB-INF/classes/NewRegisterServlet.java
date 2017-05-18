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
import com.Authenticate;

public class NewRegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
    response.setContentType("text/html");
	String userid = request.getParameter("userid");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
	
	//RegisterUsers users = new RegisterUsers(userid,password,email);
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
		PreparedStatement ps = conn.prepareStatement("insert into Registration values(?,?,?)");
		ps.setString(1,userid);
		ps.setString(2,password);
		ps.setString(3,email);
		int i = ps.executeUpdate();	
		if(i > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request,response);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
}