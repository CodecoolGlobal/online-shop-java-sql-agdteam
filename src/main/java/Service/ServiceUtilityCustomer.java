package Service;

import DAO.*;
import Model.Customer;
import View.ViewCustomer;

public class ServiceUtilityCustomer {
	private ViewCustomer viewAdmin;
	private CustomerDAO customerDAO;
	private FeedbackDAO feedbackDAO;
	private OrdersDAO ordersDAO;
	private ProductsDAO productsDAO;
	private Customer customer;

	public ServiceUtilityCustomer(CustomerDAO customerDAO, FeedbackDAO feedbackDAO, OrdersDAO ordersDAO, ProductsDAO productsDAO, Customer customer) {
		this.customerDAO = customerDAO;
		this.feedbackDAO = feedbackDAO;
		this.ordersDAO = ordersDAO;
		this.productsDAO = productsDAO;
		this.customer = customer;
	}


	public void crudBasket(){

	}


	public void placeAndOrder(){


	}

	public void showOrderHistory(){

	}

	public void ShowAllProductsAvailable(){

	}

	public void rateProductsFromOrder(){

	}

}
