package DAO;

import Model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrdersDAO {
	private SQLConnector sqlConnector;

	public OrdersDAO(SQLConnector sqlConnector) {
		this.sqlConnector = sqlConnector;
	}

	public List<Order> getListAll(){

		return new ArrayList<Order>();
	}

	public void add(Order product) {

	}

	public Order get(int index) {

		return null;
	}

	public void update(int index) {

	}

	public void del(int index) {

	}

}
