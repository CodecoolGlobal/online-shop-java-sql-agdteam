package Model;

import java.util.ArrayList;
import java.util.List;

public class Category{
	private int id;
	private String name;
	private boolean isAvailable;
	private List<Product> product;


	public Category(String name) {
		this.name = name;
	}


	public List<Product> getProducts() {
		return new ArrayList<Product>();
	}


	@Override
	public String toString() {
		return "Model.Category{" +
				"id=" + id +
				", name='" + name + '\'' +
				", isAvailable=" + isAvailable +
				", product=" + product +
				'}';
	}
}
