<!doctype html>

<%!  String name;
%>

<%
	name = session.getAttribute("fname").toString();
%>

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
<% if (name != null) {
	
%>
            <li style="float:right";><a href="logout.jsp">Logout</a></li>
			<li style="float:right";><a href="#">Hello, <%=name%></a></li>
<%}%>
        </ul>
</nav>
<section id = "content">
<img src="images/r3.jpg" style = "float:right" width = "115%" height = "600" />
</section>
<aside class="sidebar" style="float:left">
		<ul>		
            <div ><li align = "center"><a href="#"><center>MENU</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>DINE-IN</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>LOCATIONS</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>TRACK ORDER</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>SHARE EXPERIENCE</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>HELP</center></a></li></div>
			<img src = "images/Ratfi.JPG" width = "300" height = "250"/>
               
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


	