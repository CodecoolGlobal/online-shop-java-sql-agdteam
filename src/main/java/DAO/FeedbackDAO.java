package DAO;

import Model.Feedback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {
	private SQLConnector sqlConnector;

	public FeedbackDAO(SQLConnector sqlConnector) {
		this.sqlConnector = sqlConnector;
	}

	public List<Feedback> getListAll(){
		sqlConnector.setResultSetByQuery("SELECT * FROM Feedback");
		List<Feedback> feedbackList = new ArrayList<>();
		try{
			while(sqlConnector.getResultSet().next()){
				feedbackList.add(feedbackByCurrentResultSet());
			}
		}catch (SQLException ex){
			ex.printStackTrace();
		}

		return feedbackList;
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

	public void add(Feedback feedback) {
		String addFeedbackQuery =
				"INSERT INTO Feedback (USERNAME, MESSAGE, DATE, STARS) " +
						"VALUES (" +
						"'"+ feedback.getUsername() +"'," +
						"'"+ feedback.getMessage() +"'," +
						"'"+ feedback.getDate() +"'," +
						"'"+ feedback.getStars() +"'" +
						");";
		executeUpdateAndCommit(addFeedbackQuery);

	}


	public Feedback get(int id) {
		String getByIdQuery =
				"SELECT * FROM FEEDBACK " +
						"WHERE ID = " + id + ";";
		sqlConnector.setResultSetByQuery(getByIdQuery);
		return feedbackByCurrentResultSet();

	}

	public void update(int id, Feedback feedback) {

		String updateFeedbackById =
				"UPDATE Feedback\n" +
				"SET\n" +
				"    USERNAME = '" + feedback.getUsername() +"',\n" +
				"    MESSAGE = '" + feedback.getMessage() + "',\n" +
				"    DATE = '" + feedback.getDate() + "',\n" +
				"    STARS = '" + feedback.getStars() + "' " +
				"WHERE\n" +
				"    ID = " + id + ";";
		executeUpdateAndCommit(updateFeedbackById);

	}
	public void remove(int id) {
		String removeFeedbackQuery =
				"DELETE FROM FEEDBACK " +
						"WHERE ID = "+ id +";";
		executeUpdateAndCommit(removeFeedbackQuery);

	}

	private void executeUpdateAndCommit(String createTableSqlFeedback) {
		try{
			sqlConnector.getStatement().executeUpdate(createTableSqlFeedback);
			sqlConnector.getConnection().commit();
		}catch (SQLException ex){
			ex.printStackTrace();
		}
	}

	private Feedback feedbackByCurrentResultSet(){
		ResultSet resultSet = sqlConnector.getResultSet();

		try{
			LocalDate date = LocalDate.parse(resultSet.getString("DATE"));
			return  new Feedback(
					resultSet.getInt("ID"),
					resultSet.getString("USERNAME"),
					resultSet.getString("MESSAGE"),
					date,
					resultSet.getInt("STARS")
			);

		}catch (SQLException  ex){
			ex.printStackTrace();
		}
		return  null;
	}
}
