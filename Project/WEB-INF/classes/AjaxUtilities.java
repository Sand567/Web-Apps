
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import com.*;

public class AjaxUtilities{

public static HashMap<String , MenuItem>  getData() {

HashMap<String,MenuItem> hm = new HashMap<String,MenuItem>();
 
 try {
	 String prodQuery = "select * from americanspice.menu";
	 ResultSet rs =  com.DBUtilities.getConnectionStatement().executeQuery(prodQuery);
 
 while(rs.next()){
         //Retrieve by column name
         String id  = rs.getString("itemid");
         String category  = rs.getString("category");
        String name  = rs.getString("iname");
String image  = rs.getString("image");
String desc  = rs.getString("description");

int price = rs.getInt("price");


		 MenuItem prod = new MenuItem(id,name,desc,price,image,category);
		
		   hm.put(id,prod);
		
        
      }
   
 
 }catch(Exception e) {
	System.out.println("Exception "+e.getMessage());
 }
 return hm;
}


public static StringBuffer readData(String targetId)
{
	StringBuffer sb = new StringBuffer();
	HashMap<String,MenuItem> products = getData();
	try{
		
		 Iterator it = products.keySet().iterator();

                while (it.hasNext()) {
                    String id = (String) it.next();
                    MenuItem product = (MenuItem) products.get(id);

                    if ( // targetId matches first name
                         product.getIname().toLowerCase().startsWith(targetId)) {

                        sb.append("<menu>");
                        sb.append("<itemid>" + product.getItemid() + "</itemid>");
                        sb.append("<iname>" + product.getIname() + "</iname>");
                        sb.append("</menu>");
                       
                    }
                }
		return sb;
		
	}catch (Exception e) {
	
	}
	return sb;	
	
}


}