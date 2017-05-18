package com;

import java.util.ArrayList;
import java.util.List;


public class Console {
    String retailer;
    String name;
    String id;
    String image;
    String condition;
    String price;
	String category;
	String zipcode;
    List<String> accessories;
    public Console(){
        accessories=new ArrayList<String>();
    }

public void setId(String id) {
	this.id = id;
}

public void setCategory(String category) {
	this.category = category;
}

public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}

public void setRetailer(String retailer) {
	this.retailer = retailer;
}


public void setImage(String image) {
	this.image = image;
}

public void setCondition(String condition) {
	this.condition = condition;
}

public void setPrice(String price) {
	this.price = price;
}

List getAccessories() {
	return accessories;
}

public void setName(String name) {
	this.name = name;
}

public String getRetailer() {
	return retailer;
}

public String getName() {
	return name;
}

public String getId() {
	return id;
}

public String getImage() {
	return image;
}

public String getCondition() {
	return condition;
}

public String getPrice() {
	return price;
}

public String getCategory() {
	return category;
}

public String getZipcode() {
	return zipcode;
}

}