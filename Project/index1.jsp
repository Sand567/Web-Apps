<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Home Page</title>
<link rel="stylesheet" href="allstyle.css" type="text/css" />
<script src="myScript.js"></script>
</head>
<body onload="init()">
<div class="container">
    <header>
    	<h1>American <span>Spice</span></h1>
        <h2>The taste of America !</h2>
		<img src = "images/thumb.jpeg" alt = "Restaurant" />
    </header>
</div>
<nav>
		<ul style="float:right";>
			<li ><input type="text" height="20px" width="50px" value="" name="searchId" id="searchId" onkeyup="doCompletion()"/>
		<div id="auto-row">
		<table id="complete-table" style="background-color:#648ed1"></table>
		</div> </li>

            <li style="float:right";><a href="index.jsp">Logout</a></li>
        </ul>
</nav>
<section id = "content" style="min-height:500px">
<img src="images/r3.jpg" style = "float:right" width = "115%" height = "600" />
</section>
<aside class="sidebar" style="float:left">
		<ul>		
            <div ><li align = "center"><a href="Menu.jsp" ><center>MENU</center></a></li></div>
			<div ><li align = "center"><a href="TableBookingForm.jsp"><center>DINE-IN</center></a></li></div>
			<div ><li align = "center"><a href="location.jsp"><center>LOCATIONS</center></a></li></div>
			<div ><li align = "center"><a href="ViewOrderForm.jsp"><center>VIEW ORDER</center></a></li></div>
			<div ><li align = "center"><a href="ReviewForm.jsp"><center>CUSTOMER REVIEWS</center></a></li></div>
			<div ><li align = "center"><a href="delicacy.jsp"><center>POPULAR DELICACIES</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>HELP</center></a></li></div>
			<a href="ShowReviews.jsp"><img src = "images/Ratfi.JPG" width = "300" height = "250"/></a>
               
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