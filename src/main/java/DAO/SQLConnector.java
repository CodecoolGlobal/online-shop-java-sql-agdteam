package DAO;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class SQLConnector {
	private static Connection connection;
	private static Statement statement;
	private Set<ResultSet> resultSet;

	private SQLConnector() {
	}

	public Set<ResultSet> currentResultSet() {

		return new HashSet<ResultSet>();
	}

	public static SQLConnector getInstance() {

		return new SQLConnector();
	}

	public void connection() {

	}

	public void executeUpdateOnDB() {

	}

	public Set<ResultSet> getResultSet(){

		return new HashSet<ResultSet>();
	}



}
