<%@page import="com.DBUtilities"%>
<%@page import="com.MenuItem"%>
<%@page import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.*"%>

<%! public static DBUtilities dbu;%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Home Page</title>
<link rel="stylesheet" href="allstyle.css" type="text/css" />
</head>
<body>
<div class="container">
    <header>		
		<h1 style= "padding-left: 5cm">American <span>Spice</span></h1>
        <h2 style= "padding-left: 5cm">The taste of America !</h2>
		<img src = "images/thumb.jpeg" style = "padding-right:90%" alt = "Restaurant" />	
    </header>
</div>
<nav>
		<ul>
			<li style="float:right";><a href="testRegister.jsp">Register</a></li>
            <li style="float:right";><a href="testLogin.jsp">Login</a></li>
        </ul>
</nav>
<section id = "content">
<div align="center" style = "font-family: Century Gothic, Arial, sans-serif";>
<%
dbu = new DBUtilities();
String line=null;
dbu.fetchMenu();
List<String> selecttweet= new ArrayList();
HashMap<String,MenuItem> selectedproducts=new HashMap<String,MenuItem>();
HashMap<String,MenuItem> productmap=DBUtilities.getFetchedMenu();
//for(Map.Entry<String,MenuItem> entry : productmap.entrySet()) {
	//System.out.println(entry.getValue().getIname());
	//System.out.println(entry.getValue().getDescription());
	//System.out.println(entry.getValue().getPrice());
	//System.out.println(entry.getValue().getImage());
	//System.out.println(entry.getValue().getCategory());
//}
for(Map.Entry<String,MenuItem> entry : productmap.entrySet())
{
if(selectedproducts.size()<2 && !selectedproducts.containsKey(entry.getKey()))
{
BufferedReader reader = new BufferedReader(new FileReader (new
File("C:\\Users\\Sandeep\\Anaconda3\\DealMatches.txt")));
line=reader.readLine();
if(line==null)
{ 
	out.println("<h3 align='center'>No Offers Found</h3>");
	break;
}
else
{ 
	do {
		if(line.contains(entry.getValue().getIname()))
		{
		out.println("<h3>"+line+"</h3>");
		out.println("<br>");
		selecttweet.add(line);
		selectedproducts.put(entry.getKey(),entry.getValue());
		break;
			}
		}while((line = reader.readLine()) != null);

		}
	}
}

//System.out.println(selectedproducts.size());
%>

<%

int i=0;
for (MenuItem m : selectedproducts.values() ){

	out.println("<form method=\"get\" action=\"addtocart.jsp\">");
	out.println("<b><p>"+m.getIname()+"</p></b>");
	out.println("<img style=\"width:200px;height:200px;border-radius:50%\" src =\""+m.getImage()+"\">");
	out.println("<div float=\"center\" style=\"max-width:200px\">");
	out.println("<small><i><p>"+m.getDescription()+"</p></i></small>");
	out.println("</div>");
	out.println("<b><p>$"+m.getPrice()+"</p></b>");
	out.println("<INPUT TYPE=\"HIDDEN\" NAME=\"loc\" VALUE=\"" +request.getParameter("selectLoc")+"\">");
	out.println("<INPUT TYPE=\"HIDDEN\" NAME=\"ordertype\" VALUE=\"" + request.getParameter("ordertype")+"\">");
	out.println("<INPUT TYPE=\"HIDDEN\" NAME=\"id\" VALUE=\"" + m.getItemid()+"\">");
    //out.printn("<INPUT TYPE=\"HIDDEN\" NAME=\"id\" VALUE=\"" + m.getItemid() + "\">");
	out.println("<button type=\"submit\">Select Item</button>");
	out.println("</form>");
	out.println("</br>");
}

%>
</div>
</section>
<aside class="sidebar" style="float:left">
		<ul>		
            <div ><li align = "center"><a href="#"><center>MENU</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>DINE-IN</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>LOCATIONS</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>TRACK ORDER</center></a></li></div>
			<div ><li align = "center"><a href="tweets.jsp"><center>SHARE EXPERIENCE</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>HELP</center></a></li></div>
			<!--<img src = "images/Ratfi.JPG" width = "340" height = "250"/>-->               
		</ul>		
</aside>
<div class="clear"></div>
<footer>	
<div class="footer-bottom">
            <center><p><strong>&copy; American Spice 2016.</strong> <a href="#">www.AmericanSpice.com</a></p></center>
</div>
</footer>

</body>
</html>


	