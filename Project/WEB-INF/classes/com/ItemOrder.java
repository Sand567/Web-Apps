package com;

public class ItemOrder {
	  private MenuItem item;
	  private int numItems;

	  public ItemOrder(MenuItem item) {
	    setItem(item);
	    setNumItems(1);
	  }

	    public ItemOrder(MenuItem item, int qty) {
	    setItem(item);
	    setNumItems(qty);
	  }  
	  
	  public MenuItem getItem() {
	    return(item);
	  }

	  protected void setItem(MenuItem item) {
	    this.item = item;
	  }

	  public String getItemID() {
	    return(getItem().getItemid());
	  }
	/*
	  public String getShortDescription() {
	    return(getItem().getShortDescription());
	  }

	  public String getLongDescription() {
	    return(getItem().getLongDescription());
	  }


	  */
	    public double getUnitCost() {
	    return(getItem().getPrice());
	  }
	  public int getNumItems() {
	    return(numItems);
	  }

	  public void setNumItems(int n) {
	    this.numItems = n;
	  }

	  public void incrementNumItems() {
	    setNumItems(getNumItems() + 1);
	  }

	  public void cancelOrder() {
	    setNumItems(0);
	  }

	  public double getTotalCost() {
		  System.out.println("into get total cost");
		  return(getNumItems() * getUnitCost());
	  }
	  
	  public String getItemName() {
		  return item.getIname();
	  }
	  
}
