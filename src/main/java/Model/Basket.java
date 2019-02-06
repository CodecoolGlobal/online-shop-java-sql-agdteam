package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Basket {
	private int id;
	private Iterator<Product> iterator;
	private List<Product> products;

	// Constructor for importing from database
	public Basket(int id) {
		this.id = id;
		products = new ArrayList<>();
	}

	// Constructor for creating new basket
	public Basket() {
		products.clear();
	}

	public Iterator<Product> getIterator() { return new ProductIterator(products); }


	public void addProduct(Product product, int amount) {
		Product productToAdd = product;
		productToAdd.setAmount(amount);
		products.add(productToAdd);
	}


	public void deleteProduct(Product product) {
		products.remove(product);
	}

	@Override
	public String toString() {
		String productsInBasketString = "Model.Basket {\n";
		for(int i = 0; i < products.size(); i++) {
			productsInBasketString +=
					products.get(i).toString();
		}
		productsInBasketString += "\n}\n";
		return productsInBasketString;
	}
}
