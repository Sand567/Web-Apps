package com;

import java.util.List;

public class Order {

	
	private String orderid;
	private String userid;
	private String orderType;
	private String location;
	private String status;
	private int total;
	private String orderDate;
	
	public Order() {
		
	}
	
	public Order(String orderNum,String user,String ordertype,String location,String status,String date,int total) {
		
		super();
		this.total = total;
		this.orderid = orderNum;
		this.userid = user;
		this.orderType=ordertype;
		this.location=location;
		this.orderDate = orderDate;
		this.status = status;
	}
	
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal() {
		return total;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderDate() {
		return orderDate;
	}
}
