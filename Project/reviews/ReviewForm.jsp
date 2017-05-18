<%@page import="com.*"%>
<%@page import="java.util.*"%>
<%@page import="com.mongodb.*"%>

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
<h1 style = "color:black">Please enter the details to write a review</h1>



<form method="post" action = "http://localhost:80/Project/Review.jsp">
<h3>MenuItem: <input type = "text/html" name="MenuItem"></h3>
<h3>Location: <input type = "text/html" name="Location"></h3>
<h3>Username: <input type = "text/html" name="Username"></h3>
<h3>Rating: <input type = "text/html" name="Rating"></h3>
<h3>ReviewComment: <input type = "text/html" name="ReviewComment"></h3>
<h3>ReviewDate : <input type="date" name = "ReviewDate" /></h3>
<input class="submit" type="submit" value="Submit Review">    
</form>
<br><br><br>
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


	