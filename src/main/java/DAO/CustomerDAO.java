package DAO;

import Model.Basket;
import Model.Customer;
import Model.Feedback;
import Model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
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

	public void createTableCustomer(){
		String createTableSqlCustomer =
				"CREATE TABLE Customer(\n" +
						"ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
						"LOGIN TEXT,\n" +
						"PASSWORD TEXT,\n" +
						"NAME TEXT,\n" +
						"SURNAME TEXT,\n" +
						"CITY TEXT,\n" +
						"ISADMIN INTEGER\n" +
						");";
		executeUpdateAndCommit(createTableSqlCustomer);
	}

	private void executeUpdateAndCommit(String createTableSqlCustomer) {
		try{
			sqlConnector.getStatement().executeUpdate(createTableSqlCustomer);
			sqlConnector.getConnection().commit();
		}catch (SQLException ex){
			ex.printStackTrace();
		}
	}

	public void add(Customer product) {

	}

	public List<Customer> getAll(){
		sqlConnector.setResultByQuery("SELECT * FROM Person");
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			while (sqlConnector.getResultSet().next()){
				customerList.add(customerByCurrentResultSet());
			}
		}catch (SQLException ex){
			ex.printStackTrace();
		}
		return customerList;


	}

	public Customer get(int index) {

//		return new Customer("test", true,"test", "password",  new Basket(), new ArrayList<Basket>(),  new ArrayList<Basket>(), new ArrayList<Feedback>());
	return null;
	}

	public void update(int index) {

	}

	public void del(int index) {

	}

	private Customer customerByCurrentResultSet(){
//		ResultSet resultSet = sqlConnector.getResultSet();
//		try{
//			return new Customer(
//					resultSet.getInt("ID"),
//					resultSet.getInt("ISADMIN"),
//					resultSet.getString("LOGIN"),
//					resultSet.getString("PASSWORD"),
//					resultSet.getString("NAME"),
//					resultSet.getInt("ORDERS"),
//					resultSet.getInt("FEEDBACKLIST")
//			);
//
//		}catch (SQLException ex){
//			ex.printStackTrace();
//		} return new Customer("NN","login",List<Basket>,true,list, list);

	return null;
	}
	public Customer getCustomerByLoginAndPassword(String login, String password){
		return null;
	}

	private List<Order> createListWithOrders(int id){
		sqlConnector.setResultByQuery("SELECT * FROM ORDERS WHERE id=" + id);
		List<Order> ordersList = new ArrayList<Order>();
		try{
			while(sqlConnector.getResultSet().next()){
				ordersList.add(ordersByCurrentResultSet());
			}
		}catch (SQLException ex){
			ex.printStackTrace();
		}
		return ordersList;
	}

	private Order ordersByCurrentResultSet(){

		ResultSet resultSet = sqlConnector.getResultSet();


		return null;
	}


	private void setResultSetByQuery(String query){
		try{
			ResultSet resultSet = sqlConnector.getResultSet();
			resultSet = sqlConnector.getStatement().executeQuery(query);
		}catch (SQLException ex){
			ex.printStackTrace();
		}
	}
}
