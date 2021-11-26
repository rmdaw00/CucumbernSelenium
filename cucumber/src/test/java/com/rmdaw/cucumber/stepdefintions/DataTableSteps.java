package com.rmdaw.cucumber.stepdefintions;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableSteps {
	@Given("I place an order for the following items")
	public void i_place_an_order_for_the_following_items(DataTable dataTable) {
	  List<List<String>> BillData = dataTable.asLists(String.class);
	  //getting lists
	  BillData.forEach(System.out::println);
	  
	  //getting every item inside every list
	  BillData.forEach(list -> list.forEach(System.out::println));
	}

	
	@Given("I place an order for the following items as map")
	public void i_place_an_order_for_the_following_items_as_map(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> BillData = dataTable.asMaps(String.class, String.class);
		  //getting maps
		  BillData.forEach(System.out::println);
		  
		  //getting every item inside every Map
		  BillData.forEach(map -> 
		  			map.keySet().forEach(key -> {
		  					System.out.printf("%s: %s %n", key, map.get(key));
		  }));
	
	}
	
	@When("I generate the bill")
	public void i_generate_the_bill() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("a bill for ${int} should be generated")
	public void a_bill_for_$_should_be_generated(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	  
	}
}
