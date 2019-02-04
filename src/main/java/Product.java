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

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				", amount=" + amount +
				", isAvailable=" + isAvailable +
				", category=" + category +
				'}';
	}
}
