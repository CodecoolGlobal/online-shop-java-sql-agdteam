package DAO;

import Model.Feedback;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {
	private SQLConnector sqlConnector;

	public FeedbackDAO(SQLConnector sqlConnector) {
		this.sqlConnector = sqlConnector;
	}

	public List<Feedback> getListAll(){

		return new ArrayList<Feedback>();
	}

	public void createTableFeedback(){
		String createTableSqlFeedback =
				"CREATE TABLE Feedback(" +
						"ID INTEGER PRIMARY KEY AUTOINCREMENT," +
						"USERNAME TEXT," +
						"MESSAGE TEXT," +
						"DATE TEXT," +
						"STARS INTEGER" +
						");";
		executeUpdateAndCommit(createTableSqlFeedback);

	}

	private void executeUpdateAndCommit(String createTableSqlFeedback) {
		try{
			sqlConnector.getStatement().executeUpdate(createTableSqlFeedback);
			sqlConnector.getConnection().commit();
		}catch (SQLException ex){
			ex.printStackTrace();
		}
	}

	public void add(Feedback feedback) {

	}

	public Feedback get(int index) {

		return new Feedback();
	}

	public void update(int index) {

	}

	public void del(int index) {

	}
}
