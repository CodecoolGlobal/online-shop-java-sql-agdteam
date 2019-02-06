package DAO;

import Model.Basket;
import Model.Customer;
import Model.Feedback;

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

	public void createTable(){
		String createTableSqlCustomer =
				"CREATE TABLE Customer(\n" +
						"ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
						"LOGIN TEXT\n" +
						"PASSWORD TEXT\n" +
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
		setResultSetByQuery("SELECT * FROM Person");
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

		return new Customer("test", "test", new ArrayList<Basket>(), true, new ArrayList<Basket>(), new ArrayList<Feedback>());
	}

	public void update(int index) {

	}

	public void del(int index) {

	}

	private Customer customerByCurrentResultSet(){
		ResultSet resultSet = sqlConnector.getResultSet();
		try{
			return new Customer(
					resultSet.getInt("ID"),
					resultSet.getString("LOGIN"),
					resultSet.getString("PASSWORD"),
					resultSet.getString("NAME"),
					resultSet.getInt("ISADMIN"),
					resultSet.getInt("ORDERS"),
					resultSet.getInt("FEEDBACKLIST")
			);
			//TODO: warunki do isadmin i jesli pusta lista, lub pelna to na liste przerobic.
			//TODO: pobrac dane z innych tabel
		}catch (SQLException ex){
			ex.printStackTrace();
		} return new Customer("NN","login",List<Basket>,true,list, list);
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
