import DAO.CustomerDAO;
import DAO.SQLConnector;

public class Main {
	public static void main(String[] args) {
		Controller controller = new Controller();
		CustomerDAO customerDAO = new CustomerDAO(new SQLConnector());


	}
}
