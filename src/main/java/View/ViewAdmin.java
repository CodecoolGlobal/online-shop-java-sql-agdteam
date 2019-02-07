package View;

import Model.Feedback;
import Model.Product;

import java.util.List;

public class ViewAdmin extends View {


	public void showAllList(List<?> productList) {
		productList.forEach(System.out::println);

	}

	public void showAllFeedback(List<Feedback> feedbackList) {
		for (Feedback feedback : feedbackList) {
			System.out.println(feedback.getId() + " : " + feedback.getStars() + " : " + feedback.getMessage() + " : " + feedback.getUsername());
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
