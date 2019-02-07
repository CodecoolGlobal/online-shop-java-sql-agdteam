package DAO;

import Model.Customer;
import Model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements InterfaceDAO<Customer> {
	private SQLConnector sqlConnector;

	public CustomerDAO(SQLConnector sqlConnector) {
		this.sqlConnector = sqlConnector;
	}


	public void createTableCustomer(){
		String createTableSqlCustomer =
				"CREATE TABLE Customer(" +
						"ID INTEGER PRIMARY KEY AUTOINCREMENT," +
						"ISADMIN INTEGER," +
						"LOGIN TEXT UNIQUE," +
						"PASSWORD TEXT," +
						"NAME TEXT"+
						");";
		executeUpdateAndCommit(createTableSqlCustomer);
	}

	public void add(Customer customer) {
		String addCustomerQuery =
				"INSERT INTO Customer (ISADMIN, LOGIN, PASSWORD, NAME) " +
						"VALUES (" +
						"'"+ customer.isAdmin() +"'," +
						"'"+ customer.getLogin() +"'," +
						"'"+ customer.getPassword() +"'," +
						"'"+ customer.getName() +"'" +
						");";
		executeUpdateAndCommit(addCustomerQuery);

	}

	public List<Customer> getAll(){
		sqlConnector.setResultSetByQuery("SELECT * FROM Customer");
		List<Customer> customerList = new ArrayList<>();
		try {
			while (sqlConnector.getResultSet().next()){
				customerList.add(customerByCurrentResultSet());
			}
		}catch (SQLException ex){
			ex.printStackTrace();
		}
		return customerList;
	}

	public Customer getCustomerByLoginAndPassword(String login, String password){
		String getLoginAndPassword = "SELECT * " +
				"FROM CUSTOMER " +
				"WHERE LOGIN='" + login +"' "+
				"AND PASSWORD='" + password +"';";
		sqlConnector.setResultSetByQuery(getLoginAndPassword);

		ResultSet resultSet = sqlConnector.getResultSet();
		if(resultSet != null){
			try{
				return new Customer(
						resultSet.getInt("ID"),
						resultSet.getInt("ISADMIN"),
						resultSet.getString("LOGIN"),
						resultSet.getString("PASSWORD"),
						resultSet.getString("NAME")
				);
			}catch (SQLException ex){
				ex.printStackTrace();
			}
		}
		else{
			return null;
		}

		return null;
	}

	public Customer get(int index) {

//		return new Customer("test", true,"test", "password",  new Basket(), new ArrayList<Basket>(),  new ArrayList<Basket>(), new ArrayList<Feedback>());
	return null;
	}

	public void update(int index, Customer updatedCustomer) {
		String updateCustomer =
				"UPDATE Customer " +
						"SET " +
						"ISADMIN = '"+ updatedCustomer.isAdmin() +"'," +
						"LOGIN = '"+ updatedCustomer.getLogin() +"'," +
						"PASSWORD ='"+ updatedCustomer.getPassword() +"'," +
						"NAME ='"+ updatedCustomer.getName() + "' " +
						"WHERE ID = " + updatedCustomer.getId()+
						");";
		executeUpdateAndCommit(updateCustomer);

	}

	public void delete(Customer customerToDelete) {
		String removeByIdQuery =
				"DELETE FROM CUSTOMER " +
						"WHERE ID = " + customerToDelete.getId() + ";";
		executeUpdateAndCommit(removeByIdQuery);
	}

	private Customer customerByCurrentResultSet(){
		ResultSet resultSet = sqlConnector.getResultSet();
		try{
			return new Customer(
					resultSet.getInt("ID"),
					resultSet.getInt("ISADMIN"),
					resultSet.getString("LOGIN"),
					resultSet.getString("PASSWORD"),
					resultSet.getString("NAME")
			);

		}catch (SQLException ex){
			ex.printStackTrace();
		} return null;
	}


	private List<Order> takeOrdersFromOrderDAObyId(int id){
		return null;

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

	private void executeUpdateAndCommit(String createTableSqlCustomer) {
		try{
			sqlConnector.getStatement().executeUpdate(createTableSqlCustomer);
			sqlConnector.getConnection().commit();
		}catch (SQLException ex){
			ex.printStackTrace();
		}
	}
}
