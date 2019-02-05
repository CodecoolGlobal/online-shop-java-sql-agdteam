package DAO;

import Model.Basket;
import Model.Customer;
import Model.Feedback;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	private SQLConnector sqlConnector;

	public CustomerDAO(SQLConnector sqlConnector) {
		this.sqlConnector = sqlConnector;
	}

	public List<Customer> getListAll(){

		return new ArrayList<Customer>();
	}

	public void add(Customer product) {

	}

	public Customer get(int index) {

		return new Customer("test", "test", new ArrayList<Basket>(), true, new ArrayList<Basket>(), new ArrayList<Feedback>());
	}

	public void update(int index) {

	}

	public void del(int index) {

	}
}
