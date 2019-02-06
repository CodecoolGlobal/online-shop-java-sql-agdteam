package Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class FeaturedCategory extends Category{
	private LocalDate expirationDate;

	public FeaturedCategory(String name, int isAvailable, LocalDate expirationDate) {
		super(name, isAvailable);
		this.expirationDate = expirationDate;
	}
}
