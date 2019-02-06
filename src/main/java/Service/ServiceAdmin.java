package Service;

import DAO.CustomerDAO;
import DAO.FeedbackDAO;
import DAO.OrdersDAO;
import DAO.ProductsDAO;
import Model.Customer;
import View.ViewAdmin;

import java.util.ArrayList;
import java.util.Arrays;

public class ServiceAdmin {
	private ServiceUtilityAdmin serviceUtilityAdmin;
	private ViewAdmin viewAdmin;
	private CustomerDAO customerDAO;
	private FeedbackDAO feedbackDAO;
	private OrdersDAO ordersDAO;
	private ProductsDAO productsDAO;
	private Customer adminUser;

	private static final ArrayList<String> ADMIN_MENU_OPTIONS = new ArrayList<>(Arrays.asList("Show All Customers", "Logout"));

	public ServiceAdmin(Customer adminUser, CustomerDAO customerDAO, FeedbackDAO feedbackDAO, OrdersDAO ordersDAO, ProductsDAO productsDAO) {
		this.adminUser = adminUser;
		this.customerDAO = customerDAO;
		this.feedbackDAO = feedbackDAO;
		this.ordersDAO = ordersDAO;
		this.productsDAO = productsDAO;
		viewAdmin = new ViewAdmin();
	}


	public void serviceAdminRun() {
		boolean adminMenuIsOn = true;
		while (adminMenuIsOn){
			int userOption = viewAdmin.getUserMenuChoice("Admin menu", ADMIN_MENU_OPTIONS);
			switch (userOption){
				case 1:
					//TODO: CustomerDAO - get all customers
					break;
				case 2:
					adminMenuIsOn = false;
					break;
			}
		}
	}
}
