package it.company.salestaxes.domain.billing;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.company.salestaxes.model.BaseProduct;
import it.company.salestaxes.model.BookProduct;
import it.company.salestaxes.model.FoodProduct;
import it.company.salestaxes.model.Receipt;
import it.company.salestaxes.model.ShoppingCart;
import it.company.salestaxes.taxcalculations.TaxCalculator;

public class BillerTest {

	private static ApplicationContext context;
	private static Biller biller;
	private static ShoppingCart orderInput1;
	private static ShoppingCart orderInput2;
	private static ShoppingCart orderInput3;
	
	List<BaseProduct> prodList;
	BookProduct book;
	FoodProduct food;
	
	@Before
	public void setUp()
	{
		initAppContext();
		biller = new Biller();
		biller.setTaxCalculator(new TaxCalculator());
		
		book = new BookProduct();
		book.setName("book");
		book.setPrice(new BigDecimal("40.00"));
		book.setImported(true);
		book.setQuantity(1);
		book.setTaxedCost(new BigDecimal("45.00"));
		
		
		food = new FoodProduct();
		food.setName("book");
		food.setPrice(new BigDecimal("30.00"));
		food.setImported(false);
		food.setQuantity(1);
		food.setTaxedCost(new BigDecimal("37.00"));
		
		prodList = new ArrayList<BaseProduct>();
		prodList.add(book);
		prodList.add(food);
	}
	
	private void initAppContext() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");

		biller = (Biller) context.getBean("biller");
		orderInput1 = (ShoppingCart) context.getBean("orderInput1");
		orderInput2 = (ShoppingCart) context.getBean("orderInput2");
		orderInput3 = (ShoppingCart) context.getBean("orderInput3");
		
	}

	@Test
	public void testCalculateTax() 
	{
		assertEquals(6.00, biller.calculateTax(new BigDecimal("40.00"), new BigDecimal("0.10"), true).doubleValue(), 0.0009);
	}

	@Test
	public void testCalcTotalProductCost() throws Exception 
	{
		assertEquals(46.00, biller.calcTotalProductCost(new BigDecimal("40.00"), new BigDecimal("6.00")).doubleValue(), 0.0009);
	}

	@Test
	public void testCalcTotalTax() throws Exception
	{
		assertEquals(12.00, biller.calcTotalTax(prodList).doubleValue(), 0.0009);
	}

	@Test
	public void testCalcTotalAmount() 
	{
		assertEquals(82, biller.calcTotalAmount(prodList).doubleValue(), 0.0009);
	}
	
	@Test
	public void testOrder1() throws Exception {
		System.out.println("Sales Taxes App \n");
		Receipt receipt = null;
		System.out.println("Input 1:\n");
		System.out.println(orderInput1.toString());
		
		System.out.println("Output 1:\n");
		biller.billItemsInCart(orderInput1);
		receipt = biller.getReceipt();
		
		assertEquals(1.5, receipt.getTotalSalesTax().doubleValue(),0.0009);
		assertEquals(29.83, receipt.getTotalAmount().doubleValue(),0.0009);
		biller.printReceipt(receipt);
	}
	
	@Test
	public void testOrder2() throws Exception {
		System.out.println("Sales Taxes App \n");
		Receipt receipt = null;
		System.out.println("Input 2:\n");
		System.out.println(orderInput2.toString());
		
		System.out.println("Output 2:\n");
		biller.billItemsInCart(orderInput2);
		receipt = biller.getReceipt();
		
		assertEquals(7.65, receipt.getTotalSalesTax().doubleValue(),0.0009);
		assertEquals(65.15, receipt.getTotalAmount().doubleValue(),0.0009);
		biller.printReceipt(receipt);
	}
	
	@Test
	public void testOrder3() throws Exception {
		System.out.println("Sales Taxes App \n");
		Receipt receipt = null;
		System.out.println("Input 3:\n");
		System.out.println(orderInput3.toString());
		
		System.out.println("Output 3:\n");
		biller.billItemsInCart(orderInput3);
		receipt = biller.getReceipt();
		
		assertEquals(6.7, receipt.getTotalSalesTax().doubleValue(),0.0009);
		assertEquals(74.68, receipt.getTotalAmount().doubleValue(),0.0009);
		biller.printReceipt(receipt);
	}

}
