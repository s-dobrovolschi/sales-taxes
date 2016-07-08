package it.company.salestaxes.taxcalculations;

import java.math.BigDecimal;

public class TaxCalculator implements ITaxCalculator 
{

	private static final BigDecimal IMPORTED_TAX_RATE = new BigDecimal("0.05");

	@Override
	public BigDecimal calculateTax(BigDecimal price, BigDecimal localTax, boolean imported)
	{
		BigDecimal tax = price.multiply(localTax);
		
		if(imported == true)
		{
			tax = tax.add(price.multiply(IMPORTED_TAX_RATE));
		}
		
		tax = MathHelper.roundoff(tax);
		
		return tax;
	}

}