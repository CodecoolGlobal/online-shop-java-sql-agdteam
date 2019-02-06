package Service;

import DAO.*;
import Model.Customer;
import View.View;

public class ServiceMain {
	private View view = new View();
	private SQLConnector sqlConnector = SQLConnector.getInstance();
	private CustomerDAO customerDAO = new CustomerDAO(sqlConnector);
	private Customer customer;
	private ServiceAdmin serviceAdmin;
	private ServiceCustomer serviceCustomer;

	public boolean handleLogin(){
		int choice;
		do {
			choice = view.getUserMainMenuChoice();
			if (choice == 1) {
				customer = customerDAO.getCustomerByLoginAndPassword(view.getName(), view.getPassword());
				if (customer == null) {
					view.displayInvalidNameOrPassword();
					break;
				} else if (customer.isAdmin()) {
					serviceAdmin = new ServiceAdmin(customer, customerDAO, sqlConnector);
					serviceAdmin.run();
				} else if (!customer.isAdmin()) {
					serviceCustomer = new ServiceCustomer(customer, customerDAO, sqlConnector);
					serviceCustomer.run();
				}
			}
		} while (choice != 3);
		return false;
	}





}
