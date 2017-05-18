package com;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.sql.*;

public class Orders {
	String prodName;
	String orderNo;
	String orderDt;
	String orderPr;
	String cardNum;
	String zipCode;
	String dDate;
	
	public Orders() {
		prodName = "";
		orderNo = "";
		orderDt = "";
		orderPr = "";
		cardNum = "";
		zipCode = "";
		dDate = "";
	}
	
	public Orders(String orderNo) {
		this.orderNo = orderNo;
	}
	public Orders(String prodName,String orderNo, String orderDt, String dDate, String orderPr, String cardNum, String zipCode) {
		this.prodName = prodName;
		this.orderNo = orderNo;
		this.orderDt = orderDt;
		this.orderPr = orderPr;
		this.cardNum = cardNum;
		this.zipCode = zipCode;
		this.dDate = dDate;
	}
	
	public Orders(String orderNo,String prodName, String orderPr, String zipCode) {
		this.orderNo = orderNo;
		this.prodName = prodName;
		this.orderPr = orderPr;
		this.zipCode = zipCode;
	}
	
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public void setOrderDt(String orderDt) {
		this.orderDt = orderDt;
	}
	
	public void setOrderPr(String orderPr) {
		this.orderPr = orderPr;
	}
	
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public void setDDate(String dDate) {
		this.dDate = dDate;
	}
	
	public String getProdName() {
		return prodName;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	
	public String getOrderDt() {
		return orderDt;
	}
	
	public String getOrderPr() {
		return orderPr;
	}
	
	public String getCardNum() {
		return cardNum;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public String getDDate() {
		return dDate;
	}
}