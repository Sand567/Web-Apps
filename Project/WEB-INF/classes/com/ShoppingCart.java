package com;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	  private ArrayList itemsOrdered;

	  /** Builds an empty shopping cart. */

	  public ShoppingCart() {
	    itemsOrdered = new ArrayList();
	  }

	  /** Returns List of ItemOrder entries giving
	   *  Item and number ordered. Declared as List instead
	   *  of ArrayList so that underlying implementation
	   *  can be changed later.
	   */

	  public List getItemsOrdered() {
	    return(itemsOrdered);
	  }

	  /** Looks through cart to see if it already contains
	   *  an order entry corresponding to item ID. If it does,
	   *  increments the number ordered. If not, looks up
	   *  Item in catalog and adds an order entry for it.
	   */

	   public synchronized void addItem(String itemID) {
		    ItemOrder order;
		    for(int i=0; i<itemsOrdered.size(); i++) {
		      order = (ItemOrder)itemsOrdered.get(i);
		      if (order.getItemID().equals(itemID)) {
		        order.incrementNumItems();
		        return;
		      }
		    }
		         ItemOrder newOrder = new ItemOrder(DBUtilities.getMenuItem(itemID));
		 
			itemsOrdered.add(newOrder);
			System.out.println("added name!!! "+newOrder.getItemName());
		  }

	  /** Looks through cart to find order entry corresponding
	   *  to item ID listed. If the designated number
	   *  is positive, sets it. If designated number is 0
	   *  (or, negative due to a user input error), deletes
	   *  item from cart.
	   */

	  public synchronized void setNumOrdered(String itemID,
	                                         int numOrdered) {
	    ItemOrder order;
	    for(int i=0; i<itemsOrdered.size(); i++) {
	      order = (ItemOrder)itemsOrdered.get(i);
	      if (order.getItemID().equals(itemID)) {
	        if (numOrdered <= 0) {
	          itemsOrdered.remove(i);
	        } else {
	          order.setNumItems(numOrdered);
	        }
	        return;
	      }
	    }
	    //ItemOrder newOrder =
	   //   new ItemOrder(SaxParser4BestDealXMLdataStore.getItem(itemID));
	  //  itemsOrdered.add(newOrder);
	    
	    ItemOrder newOrder =
	    	      new ItemOrder(DBUtilities.getMenuItem(itemID));
	    	    itemsOrdered.add(newOrder);
	  }
}
