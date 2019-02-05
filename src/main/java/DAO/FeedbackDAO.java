package DAO;

import Model.Feedback;
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
