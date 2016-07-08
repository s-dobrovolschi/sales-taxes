package it.company.salestaxes.taxcalculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathHelper {

	/** Rounds off a double value to the nearest 0.05 */
	public static BigDecimal roundoff(BigDecimal value)
	{
		BigDecimal roundedTaxAmount = new BigDecimal(Math.ceil(value.multiply(new BigDecimal("20")).doubleValue())/20);
		return roundedTaxAmount.setScale(2, RoundingMode.HALF_UP);
	}

	/** Truncates a double value to two decimal places. */
	public static BigDecimal truncate(BigDecimal value)
	{
		return value.setScale(2, RoundingMode.HALF_UP);
	}
}