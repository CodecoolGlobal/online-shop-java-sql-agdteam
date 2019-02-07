package Model;

import java.math.BigDecimal;

public class Product {
	private int id;
	private String name;
	private BigDecimal price;
	private int amount;
	private boolean isAvailable;
	private Category category;

	public Product(String name, BigDecimal price, int amount, Category category) {
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.category = category;
	}

	public Product(int id, String name, BigDecimal price, int amount, Category category){
		this(name, price, amount, category);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Category getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "Model.Product{" + "\n" +
				"id=" + id + "\n" +
				", name='" + name + '\'' + "\n" +
				", price=" + price + "\n" +
				", amount=" + amount + "\n" +
				", isAvailable=" + isAvailable + "\n" +
				", category=" + category + "\n" +
				"}\n";
	}

	public int getAmount() { return amount; }

	public void setAmount(int amount) { this.amount = amount; }
}
