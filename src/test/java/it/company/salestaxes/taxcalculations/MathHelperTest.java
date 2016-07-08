package it.company.salestaxes.taxcalculations;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import it.company.salestaxes.taxcalculations.MathHelper;

public class MathHelperTest {

	
	@Test
	public void testRoundoff() 
	{
		assertEquals(27.85, MathHelper.roundoff(new BigDecimal("27.82")).doubleValue(), 0.0009);
		assertEquals(27.85, MathHelper.roundoff(new BigDecimal("27.83")).doubleValue(), 0.0009);
		assertEquals(27.90, MathHelper.roundoff(new BigDecimal("27.875")).doubleValue(), 0.0009);
	}

}
