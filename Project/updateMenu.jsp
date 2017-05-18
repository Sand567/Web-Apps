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
        </ul>
</nav>
<section id = "content" style="min-height:500px">
<div align="center" style = "font-family: Century Gothic, Arial, sans-serif";>
<!--<img src="images/r3.jpg" style = "float:right" width = "115%" height = "600" /> -->
 <center>

  <h4>Enter the menu to update</h4>
   <form method="post" action="menuUpdate.jsp">
  <table cellpadding='2' cellspacing='5'>  
  
	<tr>
        <td>Item number</td>
        <td><input type="text" size="15" name="itnumber"></input></td>
    </tr>    
    <tr>
        <td>Item name</td>
        <td><input type="text" size="15" name="itname"></input></td>
    </tr>
    <tr>
        <td>Item Price</td>
        <td><input type="text" size="15" name="itprice"></input></td>
    </tr>
    <tr>
        <td>Description</td>
        <td><input type="text" size="15" name="description"></input></td>
    </tr>
    <tr>
        <td>Category</td>
        <td><input type="text" size="15" name="category"/></td>
    </tr>
	 <tr>
        <td>Image</td>
        <td><input type="text" size="15" name="image"/></td>
    </tr>	
    <tr>
        <td colspan='5'>
        <center> <button value="submit" > Submit </button></center>            
        </td>
    </tr>
 </table>
 </form>
 </center>
</div>
</section>
<aside class="sidebar" style="float:left">
		<ul>		
			<div ><li align = "center"><a href="deleteMenu.jsp"><center>DELETE MENU ITEM</center></a></li></div>
			<div ><li align = "center"><a href="addMenu.jsp"><center>ADD MENU ITEM</center></a></li></div>
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


	