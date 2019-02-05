import DAO.*;
import Service.ServiceAdmin;
import Service.ServiceCustomer;

public class Controller {
	private ServiceAdmin serviceAdmin;
	private ServiceCustomer serviceCustomer;
	private SQLConnector sqlConnector;
	private ProductsDAO productsDAO;
	private CustomerDAO customerDAO;
	private FeedbackDAO feedbackDAO;
	private OrdersDAO ordersDAO;


	public void mainLoop() {

	}

	public boolean loginRecognizer() {

		return false;
	}

	private boolean loginAsCustomer(){

		return false;
	}

	private boolean loginAsAdmin(){

		return false;
	}



}
