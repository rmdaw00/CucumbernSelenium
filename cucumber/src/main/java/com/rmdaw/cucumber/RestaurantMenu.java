package com.rmdaw.cucumber;

import java.util.ArrayList;

public class RestaurantMenu {
	private ArrayList<RestaurantMenuItem> restuarantItems = new ArrayList<>();

	public boolean add(RestaurantMenuItem e) throws IllegalArgumentException {
		System.out.println(">>>> adding menu item" + e.getItemName() );
		if (this.contains(e)) {
			throw new IllegalArgumentException("Duplicate Item");
		} else {
			System.out.println(">>>> count:" + (restuarantItems.size()+1));
			return restuarantItems.add(e);
		}
	} 	
	
	public boolean contains(RestaurantMenuItem e) {
		return restuarantItems.contains(e);
	}
	

}
