package com;

public class Menu 
{
private  String itemid;
private  String iname;
private  String  description;
private  int price;
private  String image;
private  String category;

public Menu() {
	this.itemid = "";
	this.iname = "";
	this.description = "";
	this.price = 0;
	this.image = "";
	this.category = "";
}

public Menu(String itemid,String iname, String description,int price,String image,String category )
{
this.itemid=itemid;
this.iname=iname;
this.description=description;
this.price=price;
this.image=image;
this.category=category;
}

public Menu(String itemid)
{

this.itemid=itemid;

}

public void setItemid(String itemid)
{
this.itemid=itemid;
}

public String getItemid()
{
return itemid;
}



public void setIname(String iname)
{
this.iname=iname;
}

public String getIname()
{
return iname;
}




public void setDescription(String description)
{
this.description=description;
}

public String getDescription()
{
return description;
}





public void setPrice(int price)
{
this.price=price;
}

public int getPrice()
{
return price;
}



public void setImage(String image)
{
this.image=image;
}

public String getImage()
{
return image;
}


public void setCategory(String category)
{
this.category=category;
}

public String getCategory()
{
return category;
}



}