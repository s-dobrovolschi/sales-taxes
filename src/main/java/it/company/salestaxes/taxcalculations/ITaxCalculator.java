package it.company.salestaxes.taxcalculations;

import java.math.BigDecimal;

public interface ITaxCalculator
{
	
	public BigDecimal calculateTax(BigDecimal price, BigDecimal tax, boolean imported);
	
}