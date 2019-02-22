package Service;

import DAO.*;
import Model.*;
import View.*;

import java.sql.SQLException;

public class ServiceMain {
	private View view = new View();
	private SQLConnector sqlConnector = SQLConnector.getInstance();
	private CustomerDAO customerDAO = new CustomerDAO(sqlConnector);
	private Customer customer;
	private ServiceCustomer serviceCustomer;


	public boolean handleLogin(){
		try {
			customer = customerDAO.getCustomerByLoginAndPassword(view.getName(), view.getPassword());
		} catch (SQLException e) {
			view.displayInvalidNameOrPassword();
			return false;
		}
		if (customer.isAdmin()) {
			ServiceAdmin serviceAdmin = new ServiceAdmin(customerDAO, sqlConnector, view);
			serviceAdmin.run();
		} else if (!customer.isAdmin()) {
			serviceCustomer = new ServiceCustomer(customer, customerDAO, sqlConnector, view);
			serviceCustomer.run();
		}
		return true;
	}

	public void handleWithOutLogin(){
		customer = new Customer(0, "anonymous", "anonymous", "anonymous", true);
		serviceCustomer = new ServiceCustomer(customer, customerDAO, sqlConnector, view);
		serviceCustomer.run();
	}

	public void handleCreateAccount(){
		String login = view.getLogin();
		String password = view.getPassword();
		String name = view.getName();
		Customer newCustomer = new Customer(0, login, password, name);
		serviceCustomer = new ServiceCustomer(newCustomer, customerDAO, sqlConnector, view);
		customerDAO.add(newCustomer);
		serviceCustomer.run();
	}
}
