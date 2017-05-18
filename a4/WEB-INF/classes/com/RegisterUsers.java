package com;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.sql.*;

public class RegisterUsers {
	String name;
	String password;
	String email;
	
	public RegisterUsers() {
		name = "";
		password = "";
		email = "";
	}
	
	public RegisterUsers(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
}