package it.company.salestaxes.model;

import java.io.Serializable;
import java.util.List;

public class ShoppingCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<BaseProduct> productList;

	public List<BaseProduct> getProductList() {
		return productList;
	}

	public void setProductList(List<BaseProduct> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		String shoppingCart = "";

		for (BaseProduct product : productList) {

			shoppingCart += (product.getQuantity() + " " + isImported(product.isImported()) + " " + product.getName()
					+ " : " + product.getPrice() + "\n");
		}

		return shoppingCart;
	}

	private String isImported(boolean imported) {
		return imported ? "imported" : "";
	}
}
