package Service;

import DAO.*;
import Model.Customer;
import Model.Order;
import Model.OrderStatus;
import Model.Product;
import View.View;
import View.ViewCustomer;
import View.ViewAdmin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static View.View.pause;

public class ServiceCustomer {
	private ServiceUtilityCustomer serviceUtilityCustomer;
	private ViewCustomer viewCustomer;
	private View view;
	private CustomerDAO customerDAO;
	private FeedbackDAO feedbackDAO;
	private OrdersDAO ordersDAO;
	private ProductsDAO productsDAO;
	private Customer customer;
	private OrderedItemsDAO orderedItemsDAO;

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
		this.orderedItemsDAO = new OrderedItemsDAO(sqlConnector);
		this.view = view;
		this.serviceUtilityCustomer = new ServiceUtilityCustomer(customerDAO, feedbackDAO, ordersDAO, productsDAO, orderedItemsDAO, customer, view);
	}

	public void run() {
		int choice;
		do {
			choice = view.getUserMenuChoice("Customer Menu", CUSTOMER_MENU_OPTIONS);
			switch (choice) {
				case 1:
					List<Product> allProd = productsDAO.getAll().stream().filter(e -> e.getAmount() > 0).collect(Collectors.toList());
					new ViewAdmin().showAllList(allProd);
					break;
				case 2:
					serviceUtilityCustomer.showBasket();
					break;
				case 3:
					serviceUtilityCustomer.addProductToBasket();
					break;
				case 4:
					serviceUtilityCustomer.placeOrder();
					//todo: jakies info ze zlozono zamowienie itp;
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


