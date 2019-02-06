package Model;

import java.util.*;

public class Category{
	private int id;
	private String name;
	private boolean isAvailable;
	private List<Product> products;


	public Category(List<Product> products, String name) {
		this.products = products;
		this.name = name;
	}


	public List<Product> getProducts() {
		return products;
	}


	@Override
	public String toString() {
		String productsInCategoryString = "";
		for(int i = 0; i < products.size(); i ++) {
			productsInCategoryString +=
					"Model.Category{\n" +
							"id=" + id + "\n"+
							", name='" + name + '\'' + "\n" +
							", isAvailable=" + isAvailable + "\n" +
							", product=" + products.get(i) + "\n" +
							"}\n";
		}
		return productsInCategoryString;
	}
}
