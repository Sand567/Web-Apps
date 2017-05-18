<!doctype html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Register Form</title>  
  <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
  <link rel="stylesheet" href="allstyle.css">
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
            <li style="float:right";><a href="Logout.jsp">Logout</a></li>
        </ul>
</nav>
<section id = "content" style="min-height:500px">
<!--<img src="images/r3.jpg" style = "float:right" width = "115%" height = "600" />-->
      <div class="wrapper">
      <form class="form-signin" action = "newRegister.jsp" method = "post">    
      <h3 class="form-signin-heading">Please Register</h3>
	  <input type="text" class="form-control" name="fname" placeholder="First Name" required="" autofocus="" /><br>
	  <input type="text" class="form-control" name="lname" placeholder="Last Name" required="" autofocus="" /><br>
      <input type="text" class="form-control" name="email" placeholder="Email Address" required="" autofocus="" /><br>
      <input type="password" class="form-control" name="password" placeholder="Password" required=""/>
	  <input type="password" class="form-control" name="confirmPass" placeholder="Confirm password" required="" /><br>
      <button class="btn btn-lg btn-primary btn-block" style="background-color:#E1311C" height="20px" type="submit">Sign up</button>   
    </form>
  </div> 
</section>
<aside class="sidebar" style="float:left">
		<ul>		
            <div ><li align = "center"><a href="#"><center>MENU</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>DINE-IN</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>LOCATIONS</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>TRACK ORDER</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>SHARE EXPERIENCE</center></a></li></div>
			<div ><li align = "center"><a href="#"><center>HELP</center></a></li></div>
			<!--<img src = "images/Ratfi.JPG" width = "300" height = "250"/>-->
               
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


	