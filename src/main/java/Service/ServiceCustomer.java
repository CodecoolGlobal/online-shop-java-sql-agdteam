package Service;

import DAO.*;
import View.ViewCustomer;

public class ServiceCustomer {
	private ServiceUtilityAdmin serviceUtilityAdmin;
	private ViewCustomer viewCustomer;
	private CustomerDAO customerDAO;
	private FeedbackDAO feedbackDAO;
	private OrdersDAO ordersDAO;
	private ProductsDAO productsDAO;


	public ServiceCustomer(CustomerDAO customerDAO, FeedbackDAO feedbackDAO, OrdersDAO ordersDAO, ProductsDAO productsDAO) {
		this.customerDAO = customerDAO;
		this.feedbackDAO = feedbackDAO;
		this.ordersDAO = ordersDAO;
		this.productsDAO = productsDAO;
	}

	public void serviceCustomerRun() {

	}
}
