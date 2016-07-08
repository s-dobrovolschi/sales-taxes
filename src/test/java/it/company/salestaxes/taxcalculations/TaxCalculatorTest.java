package it.company.salestaxes.taxcalculations;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class TaxCalculatorTest {

	ITaxCalculator taxcalc = new TaxCalculator();
	
	@Test
	public void testCalculateTax()
	{
		assertEquals(7.15, taxcalc.calculateTax(new BigDecimal("47.50"), new BigDecimal("0.10"), true).doubleValue(), 0.0009);
		assertEquals(0.50, taxcalc.calculateTax(new BigDecimal("10.00"), BigDecimal.ZERO, true).doubleValue(), 0.0009);
		assertEquals(1.50, taxcalc.calculateTax(new BigDecimal("14.99"), new BigDecimal("0.10"), false).doubleValue(),0.0009);
		assertEquals(0, taxcalc.calculateTax(new BigDecimal("12.49"), BigDecimal.ZERO, false).doubleValue(), 0.0009);
	}

}