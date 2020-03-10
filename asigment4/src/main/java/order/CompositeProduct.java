package order;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem {
	
	private String compItem;
	//private int priceC;

	private List<MenuItem> itemList= new ArrayList<MenuItem>(); 
	
	public CompositeProduct(String compItem) {
		this.compItem=compItem;
		//this.priceC=priceC;
	}

	@Override
	public int computePrice() {
		int a=0;
		for(MenuItem it:itemList) {
			a+=it.computePrice();
		}
		return a;
	}
	
	public void addItem(MenuItem item) {
		itemList.add(item);
	}
	
	public void deleteItem(MenuItem item) {
		itemList.remove(item);
	}
	
	 public MenuItem getChild(int i) {
	        return (MenuItem)itemList.get(i);
	    }
	 
	 public String getName() {
	        return compItem;
	    }
	  
}

