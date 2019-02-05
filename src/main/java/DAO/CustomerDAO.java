package DAO;

import Model.Customer;
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

		return new Customer();
	}

	public void update(int index) {

	}

	public void del(int index) {

	}
}
