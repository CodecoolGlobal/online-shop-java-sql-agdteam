package Service;

import DAO.*;
import Model.Product;
import View.View;
import View.ViewAdmin;

import java.math.BigDecimal;

import static View.View.pause;

public class ServiceUtilityAdmin {
	private ViewAdmin viewAdmin;
	private CustomerDAO customerDAO;
	private FeedbackDAO feedbackDAO;
	private OrdersDAO ordersDAO;
	private ProductsDAO productsDAO;

	public ServiceUtilityAdmin(CustomerDAO customerDAO, FeedbackDAO feedbackDAO, OrdersDAO ordersDAO, ProductsDAO productsDAO) {
		this.customerDAO = customerDAO;
		this.feedbackDAO = feedbackDAO;
		this.ordersDAO = ordersDAO;
		this.productsDAO = productsDAO;
		this.viewAdmin = new ViewAdmin();
	}

	public void crudProducts() {

	}

	public void crudCategories(View view){
		int choice;
		do {
			choice = view.getAdminCrudMenuChoice();
			switch (choice) {
				case 1:
					String name = view.getProductName();
					BigDecimal price = new BigDecimal(String.valueOf(view.getPrice()));
					int amount = view.getAmount();
//					System.out.println(price + " : " + price.getClass().getName());
//					productsDAO.add(new Product());
					pause();
					break;
			}


		} while (choice != 0);
	}

	public void crudCustomers(){

	}

	public void showOrders(){

	}

	public void showFeedback(){

	}

}
