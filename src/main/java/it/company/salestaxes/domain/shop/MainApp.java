package it.company.salestaxes.domain.shop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.company.salestaxes.domain.billing.Biller;
import it.company.salestaxes.model.Receipt;
import it.company.salestaxes.model.ShoppingCart;

public class MainApp {

	private static Biller biller;
	private static ShoppingCart orderInput1;
	private static ShoppingCart orderInput2;
	private static ShoppingCart orderInput3;
	private static ApplicationContext context;
	
	public static void main(String[] args) throws Exception {
		initAppContext();
		
		System.out.println("Sales Taxes App \n");
		Receipt receipt = null;
		System.out.println("Input 1:\n");
		System.out.println(orderInput1.toString());
		
		System.out.println("Output 1:\n");
		biller.billItemsInCart(orderInput1);
		receipt = biller.getReceipt();
		biller.printReceipt(receipt);
		
		System.out.println("Input 2:\n");
		System.out.println(orderInput2.toString());
		
		System.out.println("Output 2:\n");
		biller.billItemsInCart(orderInput2);
		receipt = biller.getReceipt();
		biller.printReceipt(receipt);
		
		System.out.println("Input 3:\n");
		System.out.println(orderInput3.toString());
		
		System.out.println("Output 3:\n");
		biller.billItemsInCart(orderInput3);
		receipt = biller.getReceipt();
		biller.printReceipt(receipt);
		
	}
	
	private static void initAppContext() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");

		biller = (Biller) context.getBean("biller");
		orderInput1 = (ShoppingCart) context.getBean("orderInput1");
		orderInput2 = (ShoppingCart) context.getBean("orderInput2");
		orderInput3 = (ShoppingCart) context.getBean("orderInput3");
		
	}
}
