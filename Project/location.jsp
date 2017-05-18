<%@page import="com.*"%>
<%@page import="java.util.*"%>
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
    	<h1>American <span>Spice</span></h1>
        <h2>The taste of America !</h2>
		<img src = "images/thumb.jpeg" alt = "Restaurant" />
    </header>
</div>
<nav>
		<ul>
			<li style="float:right";><a href="index.jsp">Logout</a></li>		
             <li style="float:right";><a href="viewcart.jsp">ViewCart</a></li>
        </ul>
</nav>
<section id = "content" style="min-height:500px">
<div align="center" style = "font-family: Century Gothic, Arial, sans-serif";>
<p><b><h1>American spice 180 N Lasalle</h1></b></p>
<%
List<Location> loc = DBUtilities.getRestaurantLocations();
int i=0;
for (Location l : loc ){
	i++;
	if(i==1){
	out.println("<img src = \"images/img1.jpeg\" style=\"width:1300px;height:400px\"\">");	
	}else{
	out.println("<img src = \"images/img2.jpg\" style=\"width:1300px;height:400px\"\">");	
	}
	out.println("<p> <b>Address:</b> <strong>"+l.getAddress()+"</strong></p>");
	out.println("<p> <b>Phone:</b> <strong>"+l.getPhoneNumber()+"</strong></p>");
	out.println("<form action=\"http://maps.google.com/maps\" method=\"get\" target=\"_blank\">");
	
	out.println("<input type=\"hidden\" name=\"saddr\" value=\"\"/>");
    out.println("<input type=\"hidden\" name=\"daddr\" value=\""+l.getAddress()+"\" />");
	out.println("<input type=\"submit\" value=\"Get directions\" />");
	out.println("</form>");
	out.println("</br>");
}
%>
</div>
</section>
<aside class="sidebar" style="float:left">
		<ul>		
			<div ><li align = "center"><a href="index1.jsp" >HOME</a></li></div>
            <div ><li align = "center"><a href="Menu.jsp" >MENU</a></li></div>
			<div ><li align = "center"><a href="TableBookingForm.jsp">DINE-IN</a></li></div>
			<div ><li align = "center"><a href="#">TRACK ORDER</a></li></div>
			<div ><li align = "center"><a href="#">SHARE EXPERIENCE</a></li></div>
			<div ><li align = "center"><a href="#">HELP</a></li></div>
			<!--<img src = "images/Ratfi.JPG" width = "350" height = "250"/>-->
               
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


	