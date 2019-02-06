package DAO;

import java.io.File;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class SQLConnector {
	private  Connection connection;

	private  Statement statement;

	private ResultSet resultSet;

	private CustomerDAO customerDAO;


	public SQLConnector() {

		try{
			System.out.println(new File("").getAbsolutePath());

			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:AGDShop.db");
			connection.setAutoCommit(false);
			statement = connection.createStatement();

		}catch (Exception ex){
			ex.printStackTrace();
		}
		createTableIfDataFileIsEmpty();

	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	private void createTableIfDataFileIsEmpty() {
		setResultByQuery("SELECT * FROM Customer");
		if (resultSet==null){
			System.out.println("DataBase not found, creating AGDShop...");
			CustomerDAO customerDAO = new CustomerDAO(this);
			customerDAO.createTable();
		}

	}

	private void setResultByQuery(String query) {
		try{
			resultSet = statement.executeQuery(query);
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public SQLConnector getInstance() {

		return new SQLConnector();
	}

	public void connection() {

	}

	public void executeUpdateOnDB() {

	}




}
