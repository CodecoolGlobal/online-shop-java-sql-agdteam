package Service;

import DAO.*;
import View.*;
import Model.Customer;
import java.util.*;

import static View.View.pause;

public class ServiceAdmin {
	private ServiceUtilityAdmin serviceUtilityAdmin;
	private ViewAdmin viewAdmin;
	private View view;
	private CustomerDAO customerDAO;
	private FeedbackDAO feedbackDAO;
	private OrdersDAO ordersDAO;
	private ProductsDAO productsDAO;
	private Customer adminUser;

	public ServiceAdmin(Customer adminUser, CustomerDAO customerDAO, SQLConnector sqlConnector, View view) {
		this.adminUser = adminUser;
		this.customerDAO = customerDAO;
		this.feedbackDAO = new FeedbackDAO(sqlConnector);
		this.ordersDAO = new OrdersDAO(sqlConnector);
		this.productsDAO = new ProductsDAO(sqlConnector);
		this.viewAdmin = new ViewAdmin();
		this.view = view;
	}


	public void run() {
		int choice;
		do {
			choice = viewAdmin.getAdminMenuChoice();
			switch (choice) {
				case 1:
					viewAdmin.showAllProduct(productsDAO.getAll());
					// todo show all product
					pause();
					break;
				case 2:
					// todo show product by category
					break;
				case 3:
					// todo show all feedback
					break;
				case 4:
					// todo edit By Id
					break;
				case 5:
					// todo remowe all unavaiable
					break;
				case 0:
					choice = 0;
			}
		} while (choice != 0);
	}





}

