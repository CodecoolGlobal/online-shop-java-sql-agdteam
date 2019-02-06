package Service;

import DAO.*;
import Model.Customer;
import View.ViewCustomer;

public class ServiceCustomer {
	private ServiceUtilityAdmin serviceUtilityAdmin;
	private ViewCustomer viewCustomer;
	private CustomerDAO customerDAO;
	private FeedbackDAO feedbackDAO;
	private OrdersDAO ordersDAO;
	private ProductsDAO productsDAO;
	private Customer customer;


	public ServiceCustomer(Customer customer, CustomerDAO customerDAO, SQLConnector sqlConnector) {
		this.customerDAO = customerDAO;
		this.feedbackDAO = new FeedbackDAO(sqlConnector);
		this.ordersDAO = new OrdersDAO(sqlConnector);
		this.productsDAO = new ProductsDAO(sqlConnector);
	}

	public void run() {

	}
}
