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
		StringBuilder productsInCategoryString = new StringBuilder();
		for(int i = 0; i < products.size(); i ++) {
			productsInCategoryString
					.append("Model.Category{\n" + "id=")
					.append(id).append("\n")
					.append(", name='")
					.append(name).append('\'')
					.append("\n")
					.append(", isAvailable=")
					.append(isAvailable)
					.append("\n")
					.append(", product=")
					.append(products.get(i))
					.append("\n")
					.append("}\n");
		}
		return productsInCategoryString.toString();
	}
}
