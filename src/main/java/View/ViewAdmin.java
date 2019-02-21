package View;

import Model.Feedback;
import Model.Product;
import de.vandermeer.asciitable.AsciiTable;

import java.util.ArrayList;
import java.util.List;

public class ViewAdmin extends View {


	public void showAllList(List<?> productList) {

		if(productList.get(0).getClass().equals(Product.class)){
			AsciiTable at = new AsciiTable();
			at.addRule();
			at.addRow("ID", "Name", "Price", "Amount", "Category");
			at.addRule();
			List<String> row = new ArrayList<>();
			for (int i = 0; i < productList.size(); i++) {
				Product product = (Product) productList.get(i);
				row.add(String.valueOf(product.getId()));
				row.add(product.getName());
				row.add(String.valueOf(product.getPrice()));
				row.add(String.valueOf(product.getAmount()));
				row.add(product.getCategory().getName());
				at.addRow(row.toArray());
				at.addRule();
				row.clear();
			}
			System.out.println(at.render(90));
		} else {
			productList.forEach(System.out::println);
		}
	}

	public void showAllFeedback(List<Feedback> feedbackList) {
		for (Feedback feedback : feedbackList) {
			System.out.println("Date: " +feedback.getDate() + " - Rating: " + feedback.getStars() + " - Message: " + feedback.getMessage() + " - Customer: " + feedback.getUsername());
		}
	}


	public void viewMainMenu() {

	}

	public void viewCRUDProductMenu(View view){
		System.out.println(CRUD_PRODUCT_MENU_OPTIONS);

	}

	public void viewOtherMenu(){

	}
}
