

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java .*;
import com.*;

/**
 *
 * @author nbuser
 */
public class AutoCompleteServlet extends HttpServlet {

    private ServletContext context;
   // private ComposerData compData = new ComposerData();
   // private HashMap composers = compData.getComposers();
    
 HashMap<String, com.MenuItem> products= new HashMap<String, com.MenuItem>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

	    products = com.DBUtilities.getMenuItemsAjax();
	    System.out.println("into autoServlet modied!!!");
	    
        String action = request.getParameter("action");
        String targetId = request.getParameter("id");
	
	 System.out.println(action);
	  System.out.println(targetId);
	
        StringBuffer sb = new StringBuffer();

        if (targetId != null) {
            targetId = targetId.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }

	
	System.out.println("into add");
        boolean namesAdded = false;
          if (action.equals("complete")) {

            // check if user sent empty string
            if (!targetId.equals("")) {
                sb=AjaxUtilities.readData(targetId);
		if(sb!=null ||!sb.equals("")) 
		{
			namesAdded=true;
		}
 
 
		System.out.println("string !!"+"<menus>" + sb.toString() + "</menus>");
            }

            if (namesAdded) {
                response.setContentType("text/xml");
                response.getWriter().write("<menus>" + sb.toString() + "</menus>");
            } else {
                //nothing to show
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }


        if (action.equals("lookup")) {

            // put the target composer in the request scope to display 
            if ((targetId != null) && products.containsKey(targetId.trim())) {
		    System.out.println("into look up id"+targetId);
            request.setAttribute("product",targetId);
	context.getRequestDispatcher("/searchresult.jsp").forward(request, response);
	
            }
        }
    }
}
