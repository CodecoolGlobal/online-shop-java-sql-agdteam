package DAO;

import Model.Feedback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FeedbackDAO {
	private SQLConnector sqlConnector;

	public FeedbackDAO(SQLConnector sqlConnector) {
		this.sqlConnector = sqlConnector;
	}

	public List<Feedback> getListAll(){
		sqlConnector.setResultByQuery("SELECT * FROM Feedback");
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


	public Feedback get(int index) {

		return null;
	}

	public void update(int index) {

	}
	public void del(int index) {

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
