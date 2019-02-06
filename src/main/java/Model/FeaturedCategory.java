package Model;

import java.util.Date;
import java.util.List;

public class FeaturedCategory extends Category{
	private Date expirationDate;

	public FeaturedCategory(String name, int isAvailable, Date expirationDate) {
		super(name, isAvailable);
		this.expirationDate = expirationDate;
	}
}
