package Service;

import DAO.*;
import View.*;
import Model.Customer;

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
	private CategoryDAO categoryDAO;
	private SQLConnector sqlConnector;

	public ServiceAdmin(Customer adminUser, CustomerDAO customerDAO, SQLConnector sqlConnector, View view) {
		this.adminUser = adminUser;
		this.customerDAO = customerDAO;
		this.feedbackDAO = new FeedbackDAO(sqlConnector);
		this.ordersDAO = new OrdersDAO(sqlConnector);
		this.productsDAO = new ProductsDAO(sqlConnector);
		this.categoryDAO = new CategoryDAO(sqlConnector);
		this.viewAdmin = new ViewAdmin();
		this.sqlConnector = sqlConnector;
		this.view = view;
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
					serviceUtilityAdmin.crudCategories();
					break;
				case 5:
//					productsDAO.delete(productsDAO.getProductById(view.getId(productsDAO.getAll().size())));
					// todo remowe all unavaiable
					break;
				case 0:
					choice = 0;
			}
		} while (choice != 0);
	}





}

