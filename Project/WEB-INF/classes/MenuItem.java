

public class MenuItem {
private String itemid;
private String iname;
private String description ;
private String image;
private int price;
private String category;


public MenuItem() {
	
}


public MenuItem(String itemid,String iname, String description,int price,String image,String category )
{
this.itemid=itemid;
this.iname=iname;
this.description=description;
this.price=price;
this.image=image;
this.category=category;
}


public String getItemid() {
	return itemid;
}
public void setItemid(String itemid) {
	this.itemid = itemid;
}
public String getIname() {
	return iname;
}
public void setIname(String iname) {
	this.iname = iname;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}

}
