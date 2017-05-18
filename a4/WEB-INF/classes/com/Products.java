package com;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.sql.*;

public class Products {
	String name;
	String id;
	String retailer;
	String price;
	String condition;
	String zipcode;
	String image;
	String category;
	//int quantity;
	
	public Products() {
		name = "";
		id = "";
		retailer = "";
		price = "";
		condition = "";
		zipcode = "";
		category = "";
	}
	
	public Products(String category) {
		this.category = category;
	}
	
	public Products(String id, String category) {
		this.id = id;
		this.category = category;
	}
	
	public Products(String name, String id, String retailer, String price, String condition, String zipcode, String category) {
		this.name = name;
		this.id =  id;
		this.retailer = retailer;
		this.price = price;
		this.condition = condition;
		this.zipcode = zipcode;
		this.category = category;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	/*public void setQuantity(int quantity) {
		this.quantity = quantity;
	}*/
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getRetailer() {
		return retailer;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public String getImage() {
		return image;
	}	
	
	public String getCategory() {
		return category;
	}
	
	/*public int getQuantity() {
		return quantity;
	}*/
}