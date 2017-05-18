<%@page import="com.DBUtilities"%>
<%@page import="com.Menu"%>
<%@page import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.*"%>


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

<%
String line=null;
List<String> selecttweet= new ArrayList();
HashMap<String,Menu> selectedproducts=new HashMap<String,Menu>();
HashMap<String,Menu> productmap=DBUtilities.getData();
for(Map.Entry<String, Menu> entry : productmap.entrySet())
{
if(selectedproducts.size()<2 && !selectedproducts.containsKey(entry.getKey()))
{
BufferedReader reader = new BufferedReader(new FileReader (new
File("F:\\595\\tomcat\\webapps\\Project\\DealMatches.txt")));
line=reader.readLine();
if(line==null)
{ out.println("<h3 align='center'>No Offers Found</h3>");break;}
else
{ do {
if(line.contains(entry.getKey()))
{
//out.println("<h3>"+line+"</h3>");
//out.println("<br>");
selecttweet.add(line);
selectedproducts.put(entry.getKey(),entry.getValue());
break;
}
}while((line = reader.readLine()) != null);

}
}
}


%>


<%

int i=0;
for (Menu m : selectedproducts.values() ){
	out.println("<h3>"+selecttweet.get(i)+"</h3>");
	i=i+1;
	out.println("<form method=\"get\" action=\"addtocart.jsp\">");
	out.println("<b><p>"+m.getIname()+"</p></b>");
	out.println("<img  style=\"width:200px;height:200px;border-radius:50%\" src =\""+m.getImage()+"\">");
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

</section>
<aside class="sidebar" style="float:left">
		<ul>		
            <div ><li align = "center"><a href="#"><center>MENU</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>DINE-IN</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>LOCATIONS</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>TRACK ORDER</center></a></li></div>
			<div ><li align = "center"><a href="tweets.jsp"><center>SHARE EXPERIENCE</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>HELP</center></a></li></div>
			<img src = "images/Ratfi.JPG" width = "340" height = "250"/>
               
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


	