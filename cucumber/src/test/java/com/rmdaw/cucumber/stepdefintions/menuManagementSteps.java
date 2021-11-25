package com.rmdaw.cucumber.stepdefintions;



import static org.junit.jupiter.api.Assertions.*;

import com.rmdaw.cucumber.RestaurantMenu;
import com.rmdaw.cucumber.RestaurantMenuItem;

import io.cucumber.java.en.*;

public class menuManagementSteps {
	RestaurantMenuItem restaurantMenuItem;
	RestaurantMenu branchMenu = new RestaurantMenu();
	
	@Given("I have a menu item with name {string} and price {int}")
	public void i_have_a_menu_item_with_name_and_price_condition(String newMenuItem, Integer price) {
	    restaurantMenuItem = new RestaurantMenuItem(newMenuItem, newMenuItem, price);
	    System.out.println("step 1");
	}

	@When("I add that menu item")
	public void i_add_that_menu_item_action() {
	    branchMenu.add(restaurantMenuItem);
	    System.out.println("step 2");
	}

	@Then("Menu item with name {string} should be added")
	public void menu_item_with_name_should_be_added_result(String string) {
	   assertAll(()-> assertTrue(branchMenu.contains(restaurantMenuItem),"does contain menu item"),
   				() -> assertTrue(true));
	   
	   System.out.println("step 3");
	}
}
