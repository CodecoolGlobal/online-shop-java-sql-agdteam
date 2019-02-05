package Service;

import DAO.*;
import View.ViewAdmin;

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
	}

	public void crudProducts() {

	}

	public void crudCategories(){

	}

	public void crudCustomers(){

	}

	public void showOrders(){

	}

	public void showFeedback(){
		
	}

}
