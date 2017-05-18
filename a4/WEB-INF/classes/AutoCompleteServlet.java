import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.MySQLUtilities;
import com.Products;
import com.Orders;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

public class AutoCompleteServlet extends HttpServlet {

	public static MySQLUtilities msu = new MySQLUtilities();
    private ServletContext context;
	
    HashMap<String,Products> hm; 
	
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		msu.fetchProducts();
		hm = msu.getFetchedProducts();
		System.out.println("in to auto");
        String action = request.getParameter("action");
        String targetId = request.getParameter("id");
		
        StringBuffer sb = new StringBuffer();

        if (targetId != null) {
            targetId = targetId.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }

        boolean namesAdded = false;
        if (action.equals("complete")) {

            // check if user sent empty string
            if (!targetId.equals("")) {

                Iterator it = hm.keySet().iterator();

                while (it.hasNext()) {
                    String id = (String) it.next();
                    Products prod = (Products) hm.get(id);

                    if ( // targetId matches first name
                         prod.getName().toLowerCase().startsWith(targetId)) {
						System.out.println("in to auto"+prod.getName());

                        sb.append("<product>");
                        sb.append("<id>" + prod.getId() + "</id>");
                        sb.append("<productName>" + prod.getName() + "</productName>");
                       
                        sb.append("</product>");
                        namesAdded = true;
                    }
                }
            }

            if (namesAdded) {
                response.setContentType("text/xml");
                response.getWriter().write("<products>" + sb.toString() + "</products>");
            } else {

                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }

        if (action.equals("lookup")) {

            if ((targetId != null) && hm.containsKey(targetId.trim())) {
				System.out.println("trgt id "+targetId);
                request.setAttribute("product", (targetId));
				
                context.getRequestDispatcher("/output").forward(request, response);
            }
        }
    }
}
