import DAO.CustomerDAO;
import DAO.FeedbackDAO;
import DAO.SQLConnector;
import Model.Feedback;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
//		Controller controller = new Controller();
		CustomerDAO customerDAO = new CustomerDAO(new SQLConnector());
//		FeedbackDAO feedbackDAO = new FeedbackDAO(new SQLConnector());
		System.out.println(customerDAO.getCustomerByLoginAndPassword("user", "haslo").getName());

	}
}
