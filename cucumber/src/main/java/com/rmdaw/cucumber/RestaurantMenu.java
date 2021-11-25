package com.rmdaw.cucumber;

import java.util.ArrayList;

public class RestaurantMenu {
	private ArrayList<RestaurantMenuItem> restuarantItems = new ArrayList<>();

	public boolean add(RestaurantMenuItem e) throws IllegalArgumentException {
		return restuarantItems.add(e);
	} 	
	
	public boolean contains(RestaurantMenuItem e) {
		return restuarantItems.contains(e);
	}
	

}
