package DAO;

import Model.Category;
import Model.Customer;
import Model.Feedback;

import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

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

		} catch (Exception ex){
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
		setResultSetByQuery("SELECT * FROM Categories");
		CategoryDAO categoryDAO = new CategoryDAO(this);
		if (resultSet==null) {
			System.out.println("DataBase not found, creating AGDShop...");
			categoryDAO.createCategoriesTable();
		}else{
//			categoryDAO.addCategory(testAddCategory());
//			System.out.println(categoryDAO.getAllCategoryList());
			}
	}

	public Feedback testAddFeedback(){
	    return new Feedback(0,"Nazwa", "Wiadomosc",
                LocalDate.now(), 5);
    }

	public Customer testAddCustomer(){
		return new Customer(0,0,"admin", "haslo",
				"Wojtek", null);
	}

	public Category testAddCategory(){
		return new Category("elektronika", 1);
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

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public static SQLConnector getInstance() {

		return new SQLConnector();
	}

	public void connection() {

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
