package com;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.sql.*;

public class DBUtilities {
	
	public static HashMap<String,MenuItem> hmap = new HashMap<String,MenuItem>();
	static Connection conn = null;
	static Statement stmt = null;
	
	public static int registerUsers(Users user) {
		int x = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/americanSpice","root","root");
			PreparedStatement ps = conn.prepareStatement("insert into RegisteredUsers values(?,?,?,?,'Customer')");
			ps.setString(1,user.getFname());
			ps.setString(2,user.getLname());
			ps.setString(3,user.getEmail());
			ps.setString(4,user.getPassword());
			
			x = ps.executeUpdate();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	
	public static String getUsers(String fname, String password) {
		boolean state = false;
		String role = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/americanSpice","root","root");
			PreparedStatement ps = conn.prepareStatement("select * from RegisteredUsers where Fname = ? and Pass = ?");
			ps.setString(1,fname);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				role = rs.getString("Role");
			}
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return role;
	}
	
	public static int addItm(Menu menu){
	int i=0;
	try {	 
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/americanSpice?useSSL=false","root","root");		 
		 PreparedStatement pstmt = conn.prepareStatement("INSERT INTO menu VALUES(?, ?, ?,?,?,?)");
		pstmt.setString(1, menu.getItemid());
		pstmt.setString(2, menu.getIname());
		pstmt.setString(3, menu.getDescription());
		pstmt.setInt(4, menu.getPrice());
		pstmt.setString(5, menu.getImage());
		pstmt.setString(6, menu.getCategory());
		i = pstmt.executeUpdate(); 
		conn.close();

	}catch(Exception e) {
		System.out.println("Exception adding order "+e.getMessage());
		}
	    return i;
	}
	
	public static int updtItm(Menu menu){
	int z=0;
	try {
		// String role = "Customer";
		 //System.out.println("in to update");
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/americanSpice?useSSL=false","root","root");
		 
		PreparedStatement pstmt = conn.prepareStatement("Update menu set iname = ?, description = ?, price = ? , image = ?, category = ? where itemid = ?");

		pstmt.setString(1, menu.getIname());
		pstmt.setString(2, menu.getDescription());
		pstmt.setInt(3, menu.getPrice());
		pstmt.setString(4, menu.getImage());
		pstmt.setString(5,menu.getCategory());
		pstmt.setString(6,menu.getItemid());
		z = pstmt.executeUpdate();
		System.out.println("z"+z);
		//System.out.println(i);
		conn.close();		
		//getConnectionStatement().executeUpdate(orderSql);
	}catch(Exception e) {
		System.out.println("Exception adding order "+e.getMessage());
	}
	 return z;
	}

	public static int delItm(Menu menu){
	int y=0;
	try {
		// String role = "Customer";
		 
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/americanSpice?useSSL=false","root","root");
		 
		 PreparedStatement pstmt = conn.prepareStatement("delete from menu where itemid = ?");
		pstmt.setString(1, menu.getItemid());
		y = pstmt.executeUpdate();
		conn.close();		
		//getConnectionStatement().executeUpdate(orderSql);
	}catch(Exception e) {
		System.out.println("Exception adding order "+e.getMessage());
	}
	 return y;
	}
	
	public static Statement getConnectionStatement() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
         // Step 1: Allocate a database Connection object
         conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/americanspice?useSSL=false", "root", "root"); // <== Check!
            // database-URL(hostname, port, default database), username, password
 
      
      stmt = conn.createStatement();
	  return stmt;
	  
	} catch(Exception e) {
		System.out.println("Exception occured "+e.getMessage());
	}
	
	return null;
	}
	
	public static void closeConnection () {
	try {
		try{stmt.close();
		}catch(Exception e){
			
		}
		try {
			System.out.println("closing conn");
			conn.close();}
		catch(Exception e){}
	} catch (Exception e){
		System.out.println("Except "+e.getMessage());
	}
	}

	public static List<Location> getRestaurantLocations() {
	
	List<Location> loc = new ArrayList<Location>(); 
	String locquery = "Select * from Locations";
	try {
		ResultSet rs = getConnectionStatement().executeQuery(locquery);
		while(rs.next()){
		String locid = rs.getString("location");
		String locname = rs.getString("address");
		String locphone = rs.getString("phonenum");
		Location l = new Location();
		l.setLocation(locid);
		l.setAddress(locname);
		l.setPhoneNumber(locphone);
		loc.add(l);
		}
		closeConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return loc;
	
	}



	public static List<MenuItem> getMenuItems() {
	
	List<MenuItem> menu = new ArrayList<>(); 
	String menuquery = "Select * from menu";
	try {
		ResultSet rs = getConnectionStatement().executeQuery(menuquery);
		while(rs.next()){
		String itemid = rs.getString("itemid");
		String iname = rs.getString("iname");
		String description = rs.getString("description");
		int price = rs.getInt("price");
		String category = rs.getString("category");
		String image = rs.getString("image");
		
		MenuItem item = new MenuItem();
		item.setCategory(category);
		item.setDescription(description);
		item.setImage(image);
		item.setPrice(price);
		item.setItemid(itemid);
		item.setIname(iname);
		System.out.println("addiems "+itemid);
		menu.add(item);
		}
		closeConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return menu;
	
	}

	public static MenuItem getMenuItem(String itemId) {
	System.out.println("item id rec"+itemId+"check");
	
	String menuquery = "Select * from menu where itemid ='"+itemId+"'";
	System.out.println("qu "+menuquery);
	MenuItem item = new MenuItem();
	try {
		ResultSet rs = getConnectionStatement().executeQuery(menuquery);
		while(rs.next()){
			System.out.println("gound res in DB");
		String itemid = rs.getString("itemid");
		String iname = rs.getString("iname");
		String description = rs.getString("description");
		int price = rs.getInt("price");
		String category = rs.getString("category");
		String image = rs.getString("image");
		
		
		item.setCategory(category);
		item.setDescription(description);
		item.setImage(image);
		item.setPrice(price);
		item.setItemid(itemid);
		item.setIname(iname);
		System.out.println("from db res "+item.getIname());
		return item;
		}
		closeConnection();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(" exce in db "+e.getMessage());
	}
	
	
	return item;
	}


	public static int getFreeTableToBook(String location , String date ,String starttime,String tablesize  ){
	try {
		
		//date format 2011-11-16
		String getFreeTableQuery ="select * from tabledetails where location ='"+location+"' "+
		"and tablesize = "+tablesize+" "+
		"and tableno not in (select TableNo from bookings where bdate = '"+date+"'  "+
				"and TableSize = "+tablesize+" and Location ='"+location+"' and starttime= "+starttime+")";
		ResultSet rs = getConnectionStatement().executeQuery(getFreeTableQuery);
		if (!rs.isBeforeFirst() ) {    
		    System.out.println("No data"); 
		    return -1;
		} 
		
		while(rs.next()){
		int freetableNum = rs.getInt("TableNo");
		System.out.println("the free table is "+freetableNum);
		return freetableNum;
		}
		
		
	}catch(Exception e){
		
	}
	
	return -1;
	}


	public static void bookTable(String userid , String location, String date ,String starttime,String tablesize ,String tableNum ){
	try {
		
			
		String bookingId = "b"+((int)(Math.random()*9000)+1000);
		//date format 2011-11-16
		
		String bookTableQuery ="insert into bookings values('"+bookingId+"','"+userid+"','"+date+"',"+starttime+","+tablesize+","+tableNum+",'"+location+"');";
		getConnectionStatement().execute(bookTableQuery);
		closeConnection();
	}catch(Exception e){
		System.out.println("Exception while booking table insert "+e.getMessage());
	}
	
	}

	public static void addOrder(String orderNum,String user,String ordertype,String location,String status,String date,int total){
	try {
		 
		String orderSql ="insert into  orders values('"+orderNum+"','"+user+"','"+ordertype+"','"+location+"','Ordered','"+date+"',"+total+")";
		System.out.println(orderSql);
		
		getConnectionStatement().executeUpdate(orderSql);
		
	}catch(Exception e) {
		System.out.println("Exception adding order "+e.getMessage());
	}
		finally{
			 closeConnection() ;
		}

	} 

	public static void addOrderItem(String orderid,String itemid,String itemname,int price,int qty,int total){
	try {
		System.out.println("orderid "+ orderid+" itemid "+itemid+" itemname");
		String orderItemSql ="insert into orderdetails values('"+orderid+"','"+itemname+"',"+qty+","+price+")";
		
		System.out.println(orderItemSql);
		
		getConnectionStatement().executeUpdate(orderItemSql);
	
	}catch(Exception e) {
		System.out.println("Exception adding orderItem "+e.getMessage());
	}
		finally{
			 closeConnection() ;
		}

	}	
	
	
	public static String getlocationName(String location){
	try {
		String orderItemSql ="select address from locations where location='"+location+"'";
		
		System.out.println(orderItemSql);
		
		ResultSet rs = getConnectionStatement().executeQuery(orderItemSql);
	    while(rs.next()){
			String loc = rs.getString("address");
			return loc;
		}
	}catch(Exception e) {
		System.out.println("Exception adding orderItem "+e.getMessage());
	}
		finally{
			 closeConnection() ;
		}
		return null;
	}
	
	public static void fetchMenu() {
		HashMap<String,MenuItem> hm = new HashMap<String,MenuItem>();
		try{
			System.out.println("test fetch");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/americanSpice","root","root");
			Statement st = conn.createStatement();
			String query = "select * from menu";
			ResultSet rs = st.executeQuery(query);
			MenuItem menu;
			while(rs.next()) {
				menu = new MenuItem();
				menu.setItemid(rs.getString("itemid"));
				menu.setIname(rs.getString("iname"));
				menu.setDescription(rs.getString("description"));
				menu.setPrice(rs.getInt("price"));
				menu.setImage(rs.getString("image"));
				menu.setCategory(rs.getString("category"));
				hm.put(rs.getString("itemid"),menu);
			}
			setFetchedMenu(hm);	
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setFetchedMenu(HashMap<String,MenuItem> hash) {
		hmap = hash;
	}
	
	public static HashMap<String,MenuItem> getFetchedMenu() {
		return hmap;
	}
	
	
	
	public static List<Order> getOrders(String orderId) {
	
	List<Order> orderlist = new ArrayList<Order>(); 
	String menuquery = "Select * from orders where OrderId =" +orderId;
	try {
		//.setString(1,orderId);
		ResultSet rs = getConnectionStatement().executeQuery(menuquery);
		while(rs.next()){
		String orderid = rs.getString("OrderId");
		String userid = rs.getString("UserId");
		String ordertype = rs.getString("OrderType");
		String location = rs.getString("Location");
		String status = rs.getString("status");
		String orderdate = rs.getString("orderdate");
		int total = rs.getInt("total");
		
		Order order = new Order();
		order.setOrderid(orderid);
		order.setUserid(userid);
		order.setOrderType(ordertype);
		order.setLocation(location);
		order.setStatus(status);
		order.setOrderDate(orderdate);
		order.setTotal(total);
		orderlist.add(order);
		}
		closeConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return orderlist;	
	}
	
	
//vt
public static HashMap<String,MenuItem> getMenuItemsAjax() {
	 HashMap<String, MenuItem> products = new HashMap<String, MenuItem>();
	try {
		
		System.out.println("the product from table");
		String getProductSQl = "select * from americanspice.menu";
		  ResultSet rs = getConnectionStatement().executeQuery(getProductSQl);
		  
		   while(rs.next()){
			 
         //Retrieve by column name
         String id  = rs.getString("itemid");
         String category  = rs.getString("category");
		 String name  = rs.getString("iname");
		 String image  = rs.getString("image");
		 String desc  = rs.getString("description");
		int price  = rs.getInt("price");
         
		
		 System.out.println("name "+name);
	
		 MenuItem temp = new MenuItem(id,name,desc,price,image,category);
		 
		 products.put(id,temp);
 
  
      }
      
      System.out.println("product hashMap after col "+products.size());
		 
	}catch (Exception e) {
		System.out.println("exception "+e.getMessage());
	}
		finally{
			 closeConnection() ;
		}

	return products;
}	
	
		
	
	


//vt
public static HashMap<String,Menu> getData() {
	 HashMap<String, Menu> products = new HashMap<String, Menu>();
	try {
		
		System.out.println("the product from table");
		String getProductSQl = "select * from americanspice.menu";
		  ResultSet rs = getConnectionStatement().executeQuery(getProductSQl);
		  
		   while(rs.next()){
			 
         //Retrieve by column name
         String id  = rs.getString("itemid");
         String category  = rs.getString("category");
		 String name  = rs.getString("iname");
		 String image  = rs.getString("image");
		 String desc  = rs.getString("description");
		int price  = rs.getInt("price");
         
		
		 System.out.println("name "+name);
	
		 Menu temp = new Menu(id,name,desc,price,image,category);
		 
		 products.put(name,temp);
 
  
      }
      
      System.out.println("product hashMap after col "+products.size());
		 
	}catch (Exception e) {
		System.out.println("exception "+e.getMessage());
	}
		finally{
			 closeConnection() ;
		}

	return products;
}	
	
	
	public static List<Menu> getMostSoldProducts() {
	  List<Menu> topsold =  new ArrayList<>();
	  HashMap<String,Menu> products = new HashMap<String,Menu>();
	  
	try {
		products = getData();
		if(topsold.size()<5) {
		System.out.println("the users from table");
		String getUsersSQl = "select itemname, SUM(quantity) as qty from americanspice.orderdetails group by(itemname) ORDER BY qty DESC limit 5";
		  ResultSet rs = getConnectionStatement().executeQuery(getUsersSQl);
		  
		   while(rs.next()){
			   
			 
         //Retrieve by column name
         String itemname  = rs.getString("itemname");
         String rating  = rs.getString("qty");
         Menu temp = products.get(itemname);
		 
		 
		 topsold.add(temp);
		   }
		 
        
      }
      
      
		closeConnection() ;
		
	}catch (Exception e) {
		System.out.println("exception "+e.getMessage());
	}
		finally{
			 closeConnection() ;
		}

	return topsold;
}

	
	
}