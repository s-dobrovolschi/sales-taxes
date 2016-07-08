package it.company.salestaxes.model;

import java.math.BigDecimal;

import it.company.salestaxes.taxcalculations.LocalTaxValues;

public class BookProduct extends BaseProduct {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public BigDecimal getTaxValue()
	{		
		return LocalTaxValues.BOOK_TAX.getValue(); 
	}
}