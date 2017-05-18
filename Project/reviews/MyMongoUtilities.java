package com;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.*;

public class MyMongoUtilities {

static DBCollection ASReviews;

public static void getConnection()
{
System.out.println("hi mongo");
MongoClient mongo;
try{
mongo = new MongoClient("localhost", 27017);
DB db = mongo.getDB("AmericanSpice");
ASReviews = db.getCollection("ASReviews");
}catch(Exception e){
System.out.println(e);
}
}    
    public static void insertReview(String menuitem,String location,String username, String reviewcomment,String rating,String reviewdate){
		try{
		System.out.println("Into insertReview");
		getConnection();
        BasicDBObject doc = new BasicDBObject("title", "ASReviews").
        append("MenuItem", menuitem).
        append("Location", location).
        append("Username", username).
        append("ReviewComment", reviewcomment).
        append("Rating", rating).
        append("ReviewDate", reviewdate);
        ASReviews.insert(doc);
		}catch(Exception e){
			System.out.println(e);
		}
  }      
  
    public static HashMap<String, ArrayList<Review>> getReviews(String menuitem){
        getConnection();
        HashMap<String, ArrayList<Review>> reviewHashmap=new HashMap<String, ArrayList<Review>>();
DBCursor cursor = ASReviews.find();
while (cursor.hasNext())
{
BasicDBObject obj = (BasicDBObject) cursor.next();

ArrayList<Review> listReview = reviewHashmap.get(obj.getString("menuitem"));

Review review = new Review();
listReview.add(review);
}
return reviewHashmap;
}


public static HashMap<String, ArrayList<Review>> getReviews()
{
getConnection();
HashMap<String, ArrayList<Review>> reviewHashmap=new HashMap<String, ArrayList<Review>>();
DBCursor cursor = ASReviews.find();
while (cursor.hasNext())
{
BasicDBObject obj = (BasicDBObject) cursor.next();
//if(!reviewHashmap.containsKey(obj.getString("model")))
//{
//ArrayList<Review> arr = new ArrayList<Review>();
//reviewHashmap.put(obj.getString("model"), arr);
//}
ArrayList<Review> listReview = reviewHashmap.get(obj.getString("model"));

Review review = new Review();
//review.storeReview(obj.getString("model"),obj.getString("category"),obj.getString("price"),obj.getString("username"),obj.getString("retailername"),obj.getString("zipcode"),obj.getString("retailercity"),obj.getString("retailerstate"),obj.getString("onsale"),obj.getString("manfname"),obj.getString("manreb"),obj.getString("age"),obj.getString("gen"),obj.getString("occ"),obj.getString("rating"),obj.getString("revdate"),obj.getString("revtext"));
listReview.add(review);
}
return reviewHashmap;
}































	
}