package DAO;

import java.io.File;
import java.sql.*;


public class SQLConnector {
	private  Connection connection;
	private  Statement statement;
	private ResultSet resultSet;
	private static SQLConnector sqlConnector;

	private SQLConnector() {
		try{
			System.out.println(new File("").getAbsolutePath());

			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:AGDShop.db");
			connection.setAutoCommit(false);
			statement = connection.createStatement();

		} catch (Exception ex){
			ex.printStackTrace();
		}
		createTableIfDataFileIsEmpty();
	}

	public static SQLConnector getInstance() {
		return (sqlConnector == null) ? new SQLConnector() : sqlConnector;
	}

	public Connection getConnection() {
		return connection;
	}

	public Statement getStatement() {
		return statement;
	}

	private void createTableIfDataFileIsEmpty() {
		setResultSetByQuery("SELECT * FROM OrderedItems");
		OrderedItemsDAO ordersDAO = new OrderedItemsDAO(this);
		if (resultSet==null) {
			System.out.println("DataBase not found, creating AGDShop...");
			ordersDAO.createOrderedItemsTable();
		}else{
//			System.out.println(ordersDAO.getAll());
			}
	}

	public void setResultSetByQuery(String query) {
		try{
			resultSet = statement.executeQuery(query);
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void executeUpdateOnDB(String update) {
		try{
			statement.executeUpdate(update);
			connection.commit();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
