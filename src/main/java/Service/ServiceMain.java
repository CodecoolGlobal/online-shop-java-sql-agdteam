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


	public void handleLogin(){
		try {
			customer = customerDAO.getCustomerByLoginAndPassword(view.getName(), view.getPassword());
		} catch (SQLException e) {
			view.displayInvalidNameOrPassword();
		}
		if (customer.isAdmin()) {
			ServiceAdmin serviceAdmin = new ServiceAdmin(customer, customerDAO, sqlConnector, view);
			serviceAdmin.run();
		} else if (!customer.isAdmin()) {
			serviceCustomer = new ServiceCustomer(customer, customerDAO, sqlConnector, view);
			serviceCustomer.run();
		}
	}

	public void handleWithOutLogin(){
		Customer anonymous = new Customer(0, 0, "Anonymous", "anonymous", "anonymous");
		serviceCustomer = new ServiceCustomer(anonymous, customerDAO, sqlConnector, view);
		serviceCustomer.run();
	}

	public void handleCreateAccount(){
		String login = view.getLogin();
		String password = view.getPassword();
		String name = view.getName();
		Customer anonymous = new Customer(0, 0, login, password, name);
		serviceCustomer = new ServiceCustomer(anonymous, customerDAO, sqlConnector, view);
		serviceCustomer.run();
	}
}
