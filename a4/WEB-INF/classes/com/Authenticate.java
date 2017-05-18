package com;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.sql.*;

public class Authenticate {
	
	public static boolean check(String userid,String password) {
		boolean state = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","root");
			PreparedStatement ps = conn.prepareStatement("select * from Registration where username = ? and password = ?");
			ps.setString(1,userid);
			ps.setString(2,password);			
			ResultSet rs = ps.executeQuery();
			state = rs.next();
			conn.close();
		}		
		catch(Exception e) {
			e.printStackTrace();
		}
		return state;
	}
}