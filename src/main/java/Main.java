import DAO.CustomerDAO;
import DAO.FeedbackDAO;
import DAO.SQLConnector;

public class Main {
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.mainLoop();
	}
}
