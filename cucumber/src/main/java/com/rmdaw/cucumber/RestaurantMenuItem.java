package com.rmdaw.cucumber;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestaurantMenuItem {
	private String itemName;
	private String description;
	private int price;
	
	
}
