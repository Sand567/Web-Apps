package com;

import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.BasicDBObject;

public class MyMongoUtilities {
    static MongoDatabase db;
    static MongoCollection<BasicDBObject> reviews;
	static MongoClient mongoClient;

    public static void getConnection(){
        mongoClient = new MongoClient("localhost", 27017);
        db = mongoClient.getDatabase("AmericanSpice");
        reviews = db.getCollection("ASReviews", BasicDBObject.class);
    }
    
    public static void insertReview(String menuitem,String location,String username, String reviewcomment,String rating,String reviewdate){
		try{
		System.out.println("Into insertReview");
		getConnection();
        BasicDBObject doc = new BasicDBObject("key", "value");
        doc.append("MenuItem", menuitem);
        doc.append("Location", location);
        doc.append("Username", username);
        doc.append("ReviewComment", reviewcomment);
        doc.append("Rating", rating);
        doc.append("ReviewDate", reviewdate);
        reviews.insertOne(doc);
		}catch(Exception e){
			System.out.println(e);
		}
        
    }
  
    public static List<Review> getReviews(String menuitem){
        getConnection();
		List<Review>  listReview = new ArrayList<Review>();
        BasicDBObject query = new BasicDBObject();
        query.put("MenuItem",menuitem);
        List<BasicDBObject> foundDocument = reviews.find(query).into(new ArrayList<BasicDBObject>());
        Map<String, String> m;
        for(BasicDBObject obj: foundDocument){
           Review r = new Review();
		   r.setMenuItem(obj.getString("MenuItem"));
		   r.setLocation(obj.getString("Location"));
           r.setUsername(obj.getString("Username"));
           r.setReviewComment(obj.getString("ReviewComment"));
           r.setRating(obj.getString("Rating"));
           r.setReviewDate(obj.getString("ReviewDate"));
		   listReview.add(r);
        }
        return listReview;
    }
	
}