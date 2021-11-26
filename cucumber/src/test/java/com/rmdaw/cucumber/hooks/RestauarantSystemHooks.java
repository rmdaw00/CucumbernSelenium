package com.rmdaw.cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class RestauarantSystemHooks {
	@Before
	public void beforeDisplayMessage(Scenario sc) {
		System.out.println(">>>> before Triggered, sc name: " + sc.getName());
	}
	
	@After("@SmokeTest") //notice now its narrowed down to only tagged scenarios
	public void afterDisplayMessage(Scenario sc) {
		System.out.println(">>>> After Triggered, sc name: " + sc.getName());
	}
	
	@BeforeAll  //note it has to be static
	public static void beforeAllScenarios() { 
		System.out.println(">>>> this is at absolute beginning before 1st sc");
	}
	
	@AfterAll
	public static void afterAllScenarios() {
		System.out.println(">>>> this is at absolute end after last sc");
	}
	
	
}
