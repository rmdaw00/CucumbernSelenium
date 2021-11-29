package com.rmdaw.cucumber.stepdefintions;

import java.math.BigDecimal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
	
	
	private boolean invokeWebPage(double expectedValue) {
		System.setProperty("webdriver.chrome.driver", "C:\\RMD\\ChromeDriver\\chromedriver.exe");
		
		ChromeDriver driver  = new ChromeDriver();
		driver.get("http://localhost:8080/SimpleSite/");
		
		WebElement billAmountTextBox = driver.findElement(By.id("billamount"));
		WebElement taxRateTextBox = driver.findElement(By.id("taxrate"));
		WebElement submitButton = driver.findElement(By.id("mybutton"));
		
		billAmountTextBox.sendKeys(initialBillAmount.toString());
		taxRateTextBox.sendKeys(taxRate.toString());
		
		submitButton.click();
		
		WebElement headerElement = driver.findElement(By.xpath("//h1"));
		
		System.out.println(headerElement.getText());
		boolean result = headerElement.getText().contains("Final Bill Amount is: $" + expectedValue);
		driver.quit();
		
		return result;
		
		
		
	}
	
	
	@Given("final bill amount calculated is {bigdecimal}")
	public void final_bill_amount_calculated_is(BigDecimal amount) {
		
		assertEquals(initialBillAmount.add(taxRate.multiply(initialBillAmount)).doubleValue(), 
					BillCalculationHelper.calculateBillForCustomer(initialBillAmount.doubleValue(),
																   taxRate.doubleValue()));
		calculatedBillAmount = initialBillAmount.add(taxRate.multiply(initialBillAmount));
		System.out.printf("calculatedBillAmount: %s %n", calculatedBillAmount.toString());
		assertEquals(true, invokeWebPage(calculatedBillAmount.doubleValue()));
	}

		
		
}
