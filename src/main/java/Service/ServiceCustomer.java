package Service;

import DAO.*;
import Model.Customer;
import Model.Product;
import View.View;
import View.ViewCustomer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceCustomer {
	private ServiceUtilityAdmin serviceUtilityAdmin;
	private ViewCustomer viewCustomer;
	private View view;
	private CustomerDAO customerDAO;
	private FeedbackDAO feedbackDAO;
	private OrdersDAO ordersDAO;
	private ProductsDAO productsDAO;
	private Customer customer;

	private static final ArrayList<String> CUSTOMER_MENU_OPTIONS =
			new ArrayList<>(Arrays.asList(
					"Show all products",
					"Show My Basket",
					"Add product to My Basket",
					"Place an order",
					"Send feedback"
			));

	public ServiceCustomer(Customer customer, CustomerDAO customerDAO, SQLConnector sqlConnector, View view) {
		this.customer = customer;
		this.customerDAO = customerDAO;
		this.feedbackDAO = new FeedbackDAO(sqlConnector);
		this.ordersDAO = new OrdersDAO(sqlConnector);
		this.productsDAO = new ProductsDAO(sqlConnector);
		this.view = view;
	}

	public void run() {
		int choice;
		do {
			choice = view.getUserMenuChoice("Customer Menu", CUSTOMER_MENU_OPTIONS);
			switch (choice){
				case 1:
					List<Product> allProducts = productsDAO.getAll();
					view.showAllList(allProducts);
					break;
				case 2:
					view.showAllList(customer.getBasket().getProducts());
					break;
				case 3:
					//add product to my basket
					break;
				case 4:
					//Place an order
					break;
				case 5:
					//send feedback
					break;
				case 0:
					break;
			}
		} while (choice != 0);
	}
}
