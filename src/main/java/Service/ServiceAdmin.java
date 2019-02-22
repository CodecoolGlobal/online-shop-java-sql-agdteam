package Service;

import DAO.*;
import View.*;

import static View.View.pause;

public class ServiceAdmin {
	private ServiceUtilityAdmin serviceUtilityAdmin;
	private ViewAdmin viewAdmin;
	private FeedbackDAO feedbackDAO;
	private ProductsDAO productsDAO;

	public ServiceAdmin(CustomerDAO customerDAO, SQLConnector sqlConnector, View view) {
		OrdersDAO ordersDAO = new OrdersDAO(sqlConnector);
		CategoryDAO categoryDAO = new CategoryDAO(sqlConnector);
		this.feedbackDAO = new FeedbackDAO(sqlConnector);
		this.productsDAO = new ProductsDAO(sqlConnector);
		this.viewAdmin = new ViewAdmin();
		this.serviceUtilityAdmin = new ServiceUtilityAdmin(customerDAO, feedbackDAO, ordersDAO, productsDAO, categoryDAO, view);
	}


	public void run() {
		int choice;
		do {
			choice = viewAdmin.getAdminMenuChoice();
			switch (choice) {
				case 1:
					viewAdmin.showAllList(productsDAO.getAll());
					pause();
					break;
				case 2:
					serviceUtilityAdmin.showProductByCategory();
					break;
				case 3:
					viewAdmin.showAllFeedback(feedbackDAO.getAll());
					pause();
					break;
				case 4:
					serviceUtilityAdmin.crudProduct();
					break;
			}
		} while (choice != 0);
	}
}
