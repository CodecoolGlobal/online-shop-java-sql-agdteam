package Service;

import DAO.*;
import Model.Customer;
import View.View;

import static Service.ServiceAdmin.pause;

public class ServiceMain {
	private View view = new View();
	private SQLConnector sqlConnector = SQLConnector.getInstance();
	private CustomerDAO customerDAO = new CustomerDAO(sqlConnector);
	private Customer customer;
	private ServiceAdmin serviceAdmin;
	private ServiceCustomer serviceCustomer;


	public void handleLogin(){
		customer = customerDAO.getCustomerByLoginAndPassword(view.getName(), view.getPassword());
		if (customer == null) {
			view.displayInvalidNameOrPassword();
			pause();
		} else if (customer.isAdmin()) {
			serviceAdmin = new ServiceAdmin(customer, customerDAO, sqlConnector, view);
			serviceAdmin.run();
		} else if (!customer.isAdmin()) {
			serviceCustomer = new ServiceCustomer(customer, customerDAO, sqlConnector, view);
			serviceCustomer.run();
		}
	}

	public void handleWithOutLogin(){
	}
}
