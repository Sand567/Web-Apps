<%@page import="com.*"%>
<%@page import="java.util.*"%>

<%
//for testing setting username 


%>


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
<h1 style = "color:black">Please enter the details to book a table</h1>
<form action="tablebooking" method="get">
<h3>Location : <select name="selectLoc"></h3>
  <%
  List<Location> loc = DBUtilities.getRestaurantLocations();
for (Location l : loc ){
	out.println("<option value="+l.getLocation()+">"+l.getAddress()+"</option>");
System.out.println("loc "+ l.getLocation());	
}
%>
</select>
<h3>Date : <input type="date" name = "date" /></h3>
<h3>Table Size: <select name="tableSize"></h3>
  <option value="2">2</option>
  <option value="4">4</option>
  <option value="6">6</option>
</select>

<h3>Time Slot: <select name="timeSlot"></h3>
  <option value="5">5:00 PM - 6.00 PM</option>
  <option value="6">6:00 PM - 7:00 PM</option>
  <option value="7">7:00 PM - 8:00 PM</option>
</select>
<br>
<input class="submit" type="submit" value="Search">    
</form>
<br><br><br>

<%
String num =null;
try {
num = request.getAttribute("tabenumber").toString();

} catch (Exception e){
	System.out.println("Exception "+e.getMessage());
}

if(num!=null){
	if(Integer.parseInt(num) == -1){
		out.println("<h3>No tables available for this timeslot, please try another slot</h3>");
	}
	else{
		out.println("Confirm the booking by clicking on Book Now");
		System.out.println("loc ^^^^"+request.getAttribute("selectLoc").toString());
		%>
		
		<form method = "get" action = "booknow">
		<input type = "hidden" name = "location" value = "<%=request.getAttribute("selectLoc").toString()%>">
		<input type = "hidden" name = "date" value = "<%=request.getAttribute("date").toString()%>">
		<input type = "hidden" name = "time" value = "<%=request.getAttribute("timeSlot").toString()%>">
		<input type = "hidden" name = "size" value = "<%=request.getAttribute("tableSize").toString()%>">
		<input type = "hidden" name = "tno" value = "<%=num%>">
		<input type = "image" src = "images/tick_red.png" width = "65" height = "65" value = "Book Now"/>
		</form>
<%
	}
}
%>
</div>
</section>

<aside class="sidebar" style="float:left">
		<ul>	
			<div ><li align = "center"><a href="index1.jsp" >HOME</a></li></div>	
            <div ><li align = "center"><a href="Menu.jsp" >MENU</a></li></div>
			<div ><li align = "center"><a href="location.jsp">LOCATIONS</a></li></div>
			<div ><li align = "center"><a href="#">TRACK ORDER</a></li></div>
			<div ><li align = "center"><a href="#">SHARE EXPERIENCE</a></li></div>
			<div ><li align = "center"><a href="#">HELP</a></li></div>
			<img src = "images/Ratfi.JPG" width = "350" height = "250"/>
               
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


	