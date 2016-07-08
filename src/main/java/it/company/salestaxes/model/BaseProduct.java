package it.company.salestaxes.model;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class BaseProduct implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String name;
	
	protected BigDecimal price;
	
	protected Boolean imported;
	
	protected Integer quantity;
	
	protected BigDecimal taxedCost;

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public BigDecimal getPrice() 
	{
		return price;
	}

	public void setPrice(BigDecimal price) 
	{
		this.price = price;
	}

	public Boolean isImported()
	{
		return imported;
	}

	public void setImported(Boolean imported)
	{
		this.imported = imported;
	}
			
	public Integer getQuantity() 
	{
		return quantity;
	}
	
	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}
	
	public BigDecimal getTaxedCost()
	{
		return taxedCost;
	}

	public void setTaxedCost(BigDecimal taxedCost) 
	{
		this.taxedCost = taxedCost;
	}

	
	@Override
	public String toString()
	{
		return (quantity + " " + getOriginType(imported) + " " + name + " : " + taxedCost);
	}
	
	public String getOriginType(boolean imported)
	{
		return imported ? "imported" : "";
	}
	
	public abstract BigDecimal getTaxValue();
}