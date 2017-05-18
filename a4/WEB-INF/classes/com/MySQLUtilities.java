package com;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.lang.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.CopyOnWriteArrayList;

public class MySQLUtilities {
	public static List<Products> alist = new CopyOnWriteArrayList<Products>();
	public static List<Products> obj = new CopyOnWriteArrayList<Products>();
	public static HashMap<String,Products> hmap = new HashMap<String,Products>();
	public static double totalCost;
	public static int addProductDB(Products product) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			PreparedStatement ps = conn.prepareStatement("insert into Products values(?,?,?,?,?,?,?)");
			ps.setString(1,product.getName());
			ps.setString(2,product.getId());
			ps.setString(3,product.getRetailer());
			ps.setString(4,product.getPrice());
			ps.setString(5,product.getCondition());
			ps.setString(6,product.getZipcode());
			ps.setString(7,product.getCategory());
			
			int i = ps.executeUpdate();
			conn.close();
			return i;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static int deleteProductDB(Products product) {
		int i = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			PreparedStatement ps = conn.prepareStatement("delete from Products where pid = ? and pcategory = ?");
			ps.setString(1,product.getId());
			ps.setString(2,product.getCategory());
			
			i = ps.executeUpdate();
			//System.out.println(i);
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static int updateProductDB(Products product) {
		int i = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			PreparedStatement ps = conn.prepareStatement("update Products set pname = ?, pretailer = ?, pprice = ?, pcondition = ?, pzip = ?, pcategory = ? where pid = ?");
			ps.setString(1,product.getName());
			ps.setString(2,product.getRetailer());
			ps.setString(3,product.getPrice());
			ps.setString(4,product.getCondition());
			ps.setString(5,product.getZipcode());
			ps.setString(6,product.getCategory());
			ps.setString(7,product.getId());			
			
			i = ps.executeUpdate();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static List<Products> getProductsDB(Products product) {
		boolean state = false;
		//List<List<String>> outer = new ArrayList<List<String>>();
		List<Products> newList = new ArrayList<Products>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			PreparedStatement ps = conn.prepareStatement("select * from Products where pcategory=?");
			ps.setString(1,product.getCategory());
			ResultSet rs = ps.executeQuery();
			Products p;
			while(rs.next()) {	
					p = new Products();				
					p.setName(rs.getString("pname"));
					p.setId(rs.getString("pid"));
					p.setRetailer(rs.getString("pretailer"));
					p.setPrice(rs.getString("pprice"));
					p.setCondition(rs.getString("pcondition"));
					p.setZipcode(rs.getString("pzip"));
					p.setCategory(product.getCategory());
					newList.add(p);					
				}
				conn.close();
			}
			catch(Exception e) {
			e.printStackTrace();
		}
		return newList;
	}

	public static List<Products> addtoCart(String id) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			PreparedStatement ps = conn.prepareStatement("select * from Products where pid = ?");
			ps.setString(1,id);
			ResultSet rs = ps.executeQuery();
			Products p;
			while(rs.next()) {
				p = new Products();
				p.setName(rs.getString("pname"));
				p.setId(id);
				p.setRetailer(rs.getString("pretailer"));
				p.setPrice(rs.getString("pprice"));
				p.setCondition(rs.getString("pcondition"));
				p.setZipcode(rs.getString("pzip"));
				p.setCategory(rs.getString("pcategory"));
				obj.add(p);				
			}
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static List<Products> deleteFromCart(String id) {
			for(Products p:obj) {
				if(p.getId().equals(id)) {
					obj.remove(p);
				}
			}
			return obj;
	}
	
	public static int confirmedOrder(Orders order) {
		int i =0;
		try{	
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			PreparedStatement ps = conn.prepareStatement("insert into Orders values(?,?,?,?,?,?,?)");
			System.out.println(order.getOrderPr());
			ps.setString(1,order.getProdName());
			ps.setString(2,order.getOrderNo());
			ps.setString(3,order.getOrderDt());
			ps.setString(4,order.getDDate());
			ps.setString(5,order.getOrderPr());
			ps.setString(6,order.getCardNum());
			ps.setString(7,order.getZipCode());
			
			i = ps.executeUpdate();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static int addOrderDB(Orders order) {
		int i =0;
		try{	
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			PreparedStatement ps = conn.prepareStatement("insert into Orders values(?,?,?,?,?,?,?)");
			System.out.println(order.getOrderPr());
			ps.setString(1,order.getProdName());
			ps.setString(2,order.getOrderNo());
			ps.setString(3,order.getOrderDt());
			ps.setString(4,order.getDDate());
			ps.setString(5,order.getOrderPr());
			ps.setString(6,order.getCardNum());
			ps.setString(7,order.getZipCode());
			
			i = ps.executeUpdate();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static int deleteOrderDB(Orders order) {
		int i = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			PreparedStatement ps = conn.prepareStatement("delete from Orders where OrderNo = ?");
			ps.setString(1,order.getOrderNo());
			
			i = ps.executeUpdate();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static int updateOrderDB(Orders order) {
		int i = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			PreparedStatement ps = conn.prepareStatement("update Orders set ProductName = ?, OrderPr = ?, ZipCode = ? where OrderNo = ?");
			ps.setString(1,order.getProdName());
			ps.setString(2,order.getOrderPr());
			ps.setString(3,order.getZipCode());
			ps.setString(4,order.getOrderNo());
			
			i = ps.executeUpdate();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static List<Products> getDetails(String id) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			PreparedStatement ps = conn.prepareStatement("select * from Products where pid = ?");
			ps.setString(1,id);
			ResultSet rs = ps.executeQuery();
			Products p;
			while(rs.next()) {
				p = new Products();
				p.setName(rs.getString("pname"));
				p.setId(id);
				p.setRetailer(rs.getString("pretailer"));
				p.setPrice(rs.getString("pprice"));
				p.setCondition(rs.getString("pcondition"));
				p.setZipcode(rs.getString("pzip"));
				p.setCategory(rs.getString("pcategory"));
				alist.add(p);				
			}
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return alist;
	}
	
	public static String getDeliveryDt(int days) {
		int addDays = days;
		DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, addDays);
		return dateFormat1.format(c.getTime());
	}
	
	public static void fetchProducts() {
		HashMap<String,Products> hm = new HashMap<String,Products>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			Statement st = conn.createStatement();
			String query = "select * from Products";
			ResultSet rs = st.executeQuery(query);
			Products prod;
			while(rs.next()) {
				prod = new Products();
				prod.setName(rs.getString("pname"));
				prod.setId(rs.getString("pid"));
				prod.setRetailer(rs.getString("pretailer"));
				prod.setPrice(rs.getString("pprice"));
				prod.setCondition(rs.getString("pcondition"));
				prod.setZipcode(rs.getString("pzip"));
				prod.setCategory(rs.getString("pcategory"));
				hm.put(rs.getString("pid"),prod);
			}
			setFetchedProducts(hm);	
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setFetchedProducts(HashMap<String,Products> hash) {
		hmap = hash;
	}
	
	public HashMap<String,Products> getFetchedProducts() {
		return hmap;
	}
}
