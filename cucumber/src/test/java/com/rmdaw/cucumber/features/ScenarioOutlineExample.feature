Feature: Final Bill Calculation
@SenarioOutline
Scenario Outline: Customer Bill Amount Calculation
Given I have a customer 
	And user enters bill amount as <InitialBillAmount>
	And sales tax rate is <TaxRate> percent
	And final bill amount calculated is <CalculatedBillAmount>
Examples:
|InitialBillAmount|TaxRate|CalculatedBillAmount	|
|100							|10			|110									|
|200							|8			|216									|
|100							|1.55		|101.55								|
