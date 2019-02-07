package View;

import Model.Product;

import java.util.List;

public class ViewAdmin extends View {


	public void showAllProduct(List<Product> productList) {
		for (Product item : productList) {
			System.out.println(item.toString());
		}
	}

	public void viewMainMenu() {

	}

	public void viewCRUDMenu(){

	}

	public void viewOtherMenu(){

	}
}
