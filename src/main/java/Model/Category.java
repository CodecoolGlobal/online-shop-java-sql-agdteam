package Model;

public class Category{
	private int id;
	private String name;
	private boolean isAvailable;


	public Category(String name, int isAvailable) {
		this.name = name;
		this.isAvailable = isAvailable == 1;
	}

	public Category(int id, String name, int isAvailable){
		this(name, isAvailable);
		this.id = id;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		isAvailable = isAvailable;
	}



/*
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
	}*/
}
