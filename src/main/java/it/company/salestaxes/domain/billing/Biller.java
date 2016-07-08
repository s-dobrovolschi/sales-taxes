package it.company.salestaxes.domain.billing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import it.company.salestaxes.model.BaseProduct;
import it.company.salestaxes.model.Receipt;
import it.company.salestaxes.model.ShoppingCart;
import it.company.salestaxes.taxcalculations.ITaxCalculator;
import it.company.salestaxes.taxcalculations.MathHelper;

public class Biller implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ITaxCalculator taxCalculator;
	private List<BaseProduct> productList;
	private Receipt receipt;
	
	public BigDecimal calculateTax(BigDecimal price, BigDecimal tax, boolean imported)
	{
		
		BigDecimal totalProductTax = taxCalculator.calculateTax(price, tax, imported);
		return totalProductTax;
	}

	public BigDecimal calcTotalProductCost(BigDecimal price, BigDecimal tax) throws Exception
	{
		BigDecimal totalCost = price.add(tax);
		return MathHelper.truncate(totalCost);
	}
	
	public BigDecimal calcTotalTax(List<BaseProduct> prodList) throws Exception
	{
		BigDecimal totalTax = BigDecimal.ZERO;
		
		for(BaseProduct product : prodList)
		{
			totalTax = totalTax.add(product.getTaxedCost().subtract(product.getPrice()));
		}
		return MathHelper.truncate(totalTax);
	}
	
	public BigDecimal calcTotalAmount(List<BaseProduct> prodList)
	{
		BigDecimal totalAmount = BigDecimal.ZERO;
		
		for(BaseProduct product : prodList)
		{
			totalAmount = totalAmount.add(product.getTaxedCost());
		}
		
		return MathHelper.truncate(totalAmount);
	}
	
	public void printReceipt(Receipt receipt)
	{
		System.out.println(receipt.toString());
	}
	
	public void billItemsInCart(ShoppingCart cart) throws Exception
	{
		productList = cart.getProductList();
		
		for(BaseProduct product : productList)
		{
			BigDecimal priceByQuantity = product.getPrice().multiply(new BigDecimal(product.getQuantity()));
			BigDecimal productTax = calculateTax(priceByQuantity, product.getTaxValue(), product.isImported());
			
			BigDecimal taxedCost = calcTotalProductCost(priceByQuantity, productTax);
			
			product.setTaxedCost(taxedCost);
		}
		
	}
	
	public Receipt getReceipt() throws Exception
	{
		BigDecimal totalTax = calcTotalTax(productList);
		BigDecimal totalAmount = calcTotalAmount(productList);
		receipt = new Receipt(productList, totalTax, totalAmount);
		return receipt;
	}

	public ITaxCalculator getTaxCalculator() {
		return taxCalculator;
	}

	public void setTaxCalculator(ITaxCalculator taxCalculator) {
		this.taxCalculator = taxCalculator;
	}
}
