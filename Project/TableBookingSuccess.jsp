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
<%

String locid = (String)request.getAttribute("location");
%>
<h1 style = "color:black">Table No : <%=request.getAttribute("tableNo")%> is reserved for <%=request.getAttribute("tablesize")%> people at location: 
<%=DBUtilities.getlocationName(locid)%>, on 
<%=request.getAttribute("bdate")%> at
 <%= request.getAttribute("timeslot")%>:00PM
</h1>

</section>
<aside class="sidebar" style="float:left">
		<ul>		
            <div ><li align = "center"><a href="Menu.jsp" >MENU</a></li></div>
			<div ><li align = "center"><a href="TableBookingForm.jsp">DINE-IN</a></li></div>
			<div ><li align = "center"><a href="location.jsp">LOCATIONS</a></li></div>
			<div ><li align = "center"><a href="#">TRACK ORDER</a></li></div>
			<div ><li align = "center"><a href="#">SHARE EXPERIENCE</a></li></div>
			<div ><li align = "center"><a href="#">HELP</a></li></div>
               
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


	