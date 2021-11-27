package com.rmdaw.cucumber;

import java.math.BigDecimal;

public class BillCalculationHelper {
	
	private BillCalculationHelper() {
	}
	
	public static double calculateBillForCustomer(double billAmountinDouble, double taxRateinDouble) {
		BigDecimal billAmount = BigDecimal.valueOf(billAmountinDouble);
		BigDecimal taxRate = BigDecimal.valueOf(taxRateinDouble);
		return billAmount.add(taxRate.multiply(billAmount)).doubleValue();
	}

	
}
