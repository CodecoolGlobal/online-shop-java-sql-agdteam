package Service;

import DAO.*;
import Model.*;
import View.*;


public class ServiceMain {
	private View view = new View();
	private SQLConnector sqlConnector = SQLConnector.getInstance();
	private CustomerDAO customerDAO = new CustomerDAO(sqlConnector);
	private Customer customer;
	private ServiceCustomer serviceCustomer;


	public void handleLogin(){
		customer = customerDAO.getCustomerByLoginAndPassword(view.getName(), view.getPassword());
		if (customer == null) {
			view.displayInvalidNameOrPassword();
		} else if (customer.isAdmin()) {
			ServiceAdmin serviceAdmin = new ServiceAdmin(customer, customerDAO, sqlConnector, view);
			serviceAdmin.run();
		} else if (!customer.isAdmin()) {
			serviceCustomer = new ServiceCustomer(customer, customerDAO, sqlConnector, view);
			serviceCustomer.run();
		}
	}

	public void handleWithOutLogin(){
		Customer anonymous = new Customer(0, 0, "Anonymous", "anonymous", "anonymous", new Basket());
		serviceCustomer = new ServiceCustomer(anonymous, customerDAO, sqlConnector, view);
		serviceCustomer.run();
	}

	public void handleCreateAccount(){
		String login = view.getLogin();
		String password = view.getPassword();
		String name = view.getName();
		Customer anonymous = new Customer(0, 0, login, password, name, new Basket());
		serviceCustomer = new ServiceCustomer(anonymous, customerDAO, sqlConnector, view);
		serviceCustomer.run();
	}
}
