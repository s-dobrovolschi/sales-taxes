package it.company.salestaxes.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

 

public class Receipt implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<BaseProduct> productList;
	
	private BigDecimal totalSalesTax;
	
	private BigDecimal totalAmount;
	
	public Receipt(List<BaseProduct> prod, BigDecimal tax, BigDecimal amount)
	{
		productList = prod;
		totalSalesTax = tax;
		totalAmount = amount;
	}
	

	public List<BaseProduct> getProductList() 
	{
		return productList;
	}

	public void setProductList(List<BaseProduct> productList) 
	{
		this.productList = productList;
	}

	public BigDecimal getTotalSalesTax() 
	{
		return totalSalesTax;
	}

	public void setTotalSalesTax(BigDecimal totalSalesTax) 
	{
		this.totalSalesTax = totalSalesTax;
	}

	public BigDecimal getTotalAmount() 
	{	
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) 
	{
		this.totalAmount = totalAmount;
	}

	public int getTotalNumberOfItems()
	{
		return productList.size();
	}
	
	@Override
	public String toString() 
	{
		String receipt = "";
		
		for(BaseProduct p: productList)
		{
			receipt += (p.toString() + "\n");
		}
		
		receipt += "Sales Taxes: " + totalSalesTax + "\n";
		receipt += "Total: " + totalAmount + "\n";
		
		return receipt;
	}
	
}
