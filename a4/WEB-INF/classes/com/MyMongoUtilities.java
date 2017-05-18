package com;

import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.AggregationOutput;
import com.mongodb.DB;

public class MyMongoUtilities {
    MongoDatabase db;
    MongoCollection<BasicDBObject> reviews;
	MongoClient mongoClient;

    public void getConnection(){
        mongoClient = new MongoClient("localhost", 27017);
        db = mongoClient.getDatabase("BestDealDB");
        reviews = db.getCollection("Reviews", BasicDBObject.class);
    }
    
    public void insertReview(String pmodel,String pcategory,String prodPrice, String retailerName,String retailerZip,String retailerCity, String retailerState,String productOnSale,String manuName, String manuRebate, String reviewDate, String userName, String userAge, String userGender, String userOccupation, String userReview, String userRating){
        this.getConnection();
        BasicDBObject doc = new BasicDBObject("key", "value");
        doc.append("ProductModel", pmodel);
        doc.append("ProductCategory", pcategory);
        doc.append("ProductPrice", prodPrice);
        doc.append("RetailerName", retailerName);
        doc.append("RetailerZip", retailerZip);
        doc.append("RetailerCity", retailerCity);
        doc.append("RetailerState", retailerState);
        doc.append("ProductOnSale", productOnSale);
        doc.append("ManufacturerName", manuName);        
        doc.append("ManufacturerRebate", manuRebate);   
        doc.append("ReviewDate", reviewDate);
        doc.append("UserId", userName);
        doc.append("UserAge", userAge);
        doc.append("UserGender", userGender);
        doc.append("UserOccupation", userOccupation);
        doc.append("Review", userReview);
		doc.append("Rating",userRating);
        this.reviews.insertOne(doc);
    }
    
    public List<Map<String, String>> getReviews(String productName){
        getConnection();
        List<Map<String, String>> listReview=new ArrayList<Map<String, String>>();
        BasicDBObject query = new BasicDBObject();
        query.put("ProductModel", productName);
        List<BasicDBObject> foundDocument = reviews.find(query).into(new ArrayList<BasicDBObject>());
        Map<String, String> m;
        for(BasicDBObject obj: foundDocument){
            m = new HashMap<String, String>();
            m.put("ManufacturerName", obj.getString("ManufacturerName"));
			m.put("ManufacturerRebate", obj.getString("ManufacturerRebate"));
            m.put("UserId", obj.getString("UserId"));
            m.put("UserAge", obj.getString("UserAge"));
            m.put("UserGender", obj.getString("UserGender"));
            m.put("UserOccupation", obj.getString("UserOccupation"));
            m.put("Rating", obj.getString("Rating"));
            m.put("RetailerZip", obj.getString("RetailerZip"));
            m.put("RetailerCity", obj.getString("RetailerCity"));
            m.put("RetailerState", obj.getString("RetailerState")); 
			m.put("ProductOnSale", obj.getString("ProductOnSale"));   
            m.put("ReviewDate", obj.getString("ReviewDate"));
            m.put("Review", obj.getString("Review"));
            m.put("ProductModel", obj.getString("ProductModel"));
            m.put("ProductCategory", obj.getString("ProductCategory"));
            m.put("ProductPrice", obj.getString("ProductPrice"));
            m.put("RetailerName", obj.getString("RetailerName")); 
            listReview.add(m);
        }
        return listReview;
    }
	
	public static List<String> getZip(){
	   List<String> zipcodes =  new ArrayList<>();
		    DBCollection collReviews;
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
         DB db = mongoClient.getDB("BestDealDB");
       collReviews = db.getCollection("Reviews");  
       DBObject groupFields= new BasicDBObject("_id", 0);
       groupFields.put("count",new BasicDBObject("$sum",1));
       groupFields.put("_id", "$RetailerZip");
       DBObject group = new BasicDBObject("$group", groupFields);
       DBObject sort = new BasicDBObject();
       DBObject projectFields= new BasicDBObject("_id", 0);
       projectFields.put("zip", "$_id");
       projectFields.put("count","$count");
       DBObject project = new BasicDBObject("$project", projectFields);
       sort.put("count",-1);
       DBObject orderby=new BasicDBObject("$sort",sort);
       DBObject limit=new BasicDBObject("$limit",5);
       AggregationOutput aggregate= collReviews.aggregate(group,project,orderby,limit);
       for (DBObject result: aggregate.results())
       {
		   String res = "";
		   res = res+result.get("zip").toString()+","+result.get("count").toString();
		   zipcodes.add(res);
       }
	   return zipcodes;
   }
}