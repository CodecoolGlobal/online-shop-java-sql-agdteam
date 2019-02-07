package Service;

import DAO.*;
import Model.Customer;
import View.View;
import View.ViewCustomer;

public class ServiceCustomer {
	private ServiceUtilityAdmin serviceUtilityAdmin;
	private ViewCustomer viewCustomer;
	private View view;
	private CustomerDAO customerDAO;
	private FeedbackDAO feedbackDAO;
	private OrdersDAO ordersDAO;
	private ProductsDAO productsDAO;
	private Customer customer;


	public ServiceCustomer(Customer customer, CustomerDAO customerDAO, SQLConnector sqlConnector, View view) {
		this.customerDAO = customerDAO;
		this.feedbackDAO = new FeedbackDAO(sqlConnector);
		this.ordersDAO = new OrdersDAO(sqlConnector);
		this.productsDAO = new ProductsDAO(sqlConnector);
		this.view = view;
	}

	public void run() {
//		viewAdmin.showProductById(Collections.singletonList(productsDAO.getProductById(view.getId(productsDAO.getAll().size()))));
	}
}
