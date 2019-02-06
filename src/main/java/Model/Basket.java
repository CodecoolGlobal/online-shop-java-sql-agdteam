package Model;

import java.util.*;

public class Basket {
	private int id;
	private Iterator<Product> iterator;
	private List<Product> products;

	public Basket(int id) {
		this.id = id;
		products = new ArrayList<>();
	}

	public Basket() {
		products = new ArrayList<>();
	}

	public ProductIterator getIterator() {
		return new ProductIterator(products); }


	public void addProduct(Product product, int amount) {
		product.setAmount(amount);
		products.add(product);
	}


	public void deleteProduct(Product product) {
		products.remove(product);
	}

	@Override
	public String toString() {
		StringBuilder productsInBasketString = new StringBuilder("Model.Basket {\n");
		for (Product product : products) {
			productsInBasketString.append(product.toString());
		}
		productsInBasketString.append("\n}\n");
		return productsInBasketString.toString();
	}
}
