package com.rmdaw.cucumber.stepdefintions;

import java.math.BigDecimal;

import com.rmdaw.cucumber.BillCalculationHelper;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.*;

public class ScenarioOutlineSteps {
	
	BigDecimal initialBillAmount;
	BigDecimal taxRate;
	BigDecimal calculatedBillAmount;
	
	@Given("I have a customer")
	public void i_have_a_customer() {
		
	}
	
	@Given("user enters bill amount as {bigdecimal}")
	public void user_enters_bill_amount_as(BigDecimal amount) {
		initialBillAmount = amount;
		System.out.printf("initialAmount: %s %n", amount);
	}
	

	@Given("sales tax rate is {bigdecimal} percent")
	public void sales_tax_rate_is_percent(BigDecimal amount) {
		taxRate = amount;
		System.out.printf("taxRate: %s %n", amount);
	}
	
	@Given("final bill amount calculated is {bigdecimal}")
	public void final_bill_amount_calculated_is(BigDecimal amount) {
		
		assertEquals(initialBillAmount.add(taxRate.multiply(initialBillAmount)).doubleValue(), 
					BillCalculationHelper.calculateBillForCustomer(initialBillAmount.doubleValue(),
																   taxRate.doubleValue()));
		calculatedBillAmount = initialBillAmount.add(taxRate.multiply(initialBillAmount));
		System.out.printf("calculatedBillAmount: %s %n", calculatedBillAmount.toString());
	}

		
		
}
