package com;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.sql.*;

public class Users {
	String fname;
	String lname;
	String password;
	String email;
	
	public Users() {
		fname = "";
		lname = "";
		password = "";
		email = "";
	}
	
	public Users(String fname, String lname, String email, String password) {
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.email = email;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFname() {
		return fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
}