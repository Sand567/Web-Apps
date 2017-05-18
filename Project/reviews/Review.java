package com;

import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.BasicDBObject;

public class Review {
  
String MenuItem;
String Location;
String Username;
String ReviewComment;
String ReviewDate;
String Rating;

public void setMenuItem(String MenuItem) {
	this.MenuItem = MenuItem;
}

public void setLocation(String Location) {
	this.Location = Location;
}

public void setUsername(String Username) {
	this.Username = Username;
}

public void setReviewComment(String ReviewComment) {
	this.ReviewComment = ReviewComment;
}

public void setReviewDate(String ReviewDate) {
	this.ReviewDate = ReviewDate;
}

public void setRating(String Rating) {
	this.Rating = Rating;
}

public String getMenuItem() {
	return MenuItem;
}

public String getLocation() {
	return Location;
}

public String getUsername() {
	return Username;
}

public String getReviewComment() {
	return ReviewComment;
}

public String getReviewDate() {
	return ReviewDate;
}

public String getRating() {
	return Rating;
}

}