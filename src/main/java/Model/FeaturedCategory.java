package Model;

import java.util.Date;
import java.util.List;

public class FeaturedCategory extends Category{
	private Date expirationDate;

	public FeaturedCategory(List<Product> products, String name, Date expirationDate) {
		super(products, name);
		this.expirationDate = expirationDate;
	}
}
