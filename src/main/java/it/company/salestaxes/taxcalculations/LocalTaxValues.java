package it.company.salestaxes.taxcalculations;

import java.math.BigDecimal;

public enum LocalTaxValues implements ITaxValues
{
	
	BOOK_TAX(BigDecimal.ZERO),
	FOOD_TAX(BigDecimal.ZERO),
	MEDICAL_TAX(BigDecimal.ZERO),
	GENERIC_TAX(new BigDecimal("0.10"));
	
	private BigDecimal itemTaxValue;
	
	private LocalTaxValues(BigDecimal taxValue)
	{
		itemTaxValue = taxValue;
	}
	
	public BigDecimal getValue()
	{
		return itemTaxValue;
	}
	
}