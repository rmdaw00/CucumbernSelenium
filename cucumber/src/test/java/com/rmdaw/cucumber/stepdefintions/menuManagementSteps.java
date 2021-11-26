package com.rmdaw.cucumber.stepdefintions;



import static org.junit.jupiter.api.Assertions.*;

import com.rmdaw.cucumber.RestaurantMenu;
import com.rmdaw.cucumber.RestaurantMenuItem;

import io.cucumber.java.en.*;

public class MenuManagementSteps {
	RestaurantMenuItem restaurantMenuItem;
	RestaurantMenu branchMenu = new RestaurantMenu();
	private String errorMessage = "";
	public MenuManagementSteps() {
		System.out.println(">>>> Constructor");
	}
	@Given("/I have a menu item with name \"([^\"]+)\" and price ([$]?)(\\d+)/")
	public void i_have_a_menu_item_with_name_and_price_condition(String newMenuItem, String currencyType, Integer price) {
	    restaurantMenuItem = new RestaurantMenuItem(newMenuItem, newMenuItem, price);
	    System.out.println(">>>> step 1");
	}

	@When("I add that menu item")
	public void i_add_that_menu_item_action() {
	    try {			
	    	branchMenu.add(restaurantMenuItem);
		} catch (IllegalArgumentException e) {
			errorMessage  = e.getMessage();
		}
	    System.out.println(">>>> step 2");
	}

	@Then("Menu item with name {string} should be added")
	public void menu_item_with_name_should_be_added_result(String string) {
	   assertAll(()-> assertTrue(branchMenu.contains(restaurantMenuItem),"does contain menu item"),
   				() -> assertTrue(true));
	   
	   System.out.println(">>>> step 3");
	}
	
	@Then("I should get an error message with {string}")
	public void i_should_get_an_error_message_with(String string) {
	   assertEquals(string, errorMessage);
	}
}
